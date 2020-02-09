import godot.*
import godot.core.Basis
import godot.core.Transform
import godot.core.Vector3

class Enemy : RigidBody() {
  private var prevAdvance = false
  private val deaccel = 20f
  private val accel = 5f
  private val maxSpeed = 2
  private var rotDir = 4
  private val rotSpeed = 1

  private var dying = false

  fun _integrate_forces(state: PhysicsDirectBodyState) {
    val delta = state.step
    var lv = state.linearVelocity
    var g = state.totalGravity
    // totalGravity returns zero for the first few frames, leading to errors
    if (g == Vector3.ZERO) {
      g = Vector3(0f, -9.8f, 0f)
    }

    // apply gravity
    lv += g * delta
    val up = -g.normalized()

    if (dying) {
      state.linearVelocity = lv
      return
    }

    for (i in 0 until state.getContactCount()) {
      val cc = state.getContactColliderObject(i)
      val dp = state.getContactLocalNormal(i)

      if (cc != null) {
        if (cc is Bullet && !cc.disabled) {
          setMode(Mode.RIGID.value)
          dying = true
          state.angularVelocity = -dp.cross(up).normalized() * 33f
          val animationPlayer = getNode<AnimationPlayer>("AnimationPlayer")
          animationPlayer.play("impact")
          animationPlayer.queue("explode")
          friction = 1f
          cc.disabled = true
          getNode<AudioStreamPlayer3D>("sound_hit").play()
        }
      }
    }

    val colFloor = getNode<RayCast>("Armature/ray_floor").isColliding()
    val colWall = getNode<RayCast>("Armature/ray_wall").isColliding()

    val advance = !colWall and colFloor

    val armature = getNode<Spatial>("Armature")
    var dir = armature.transform.basis[2].normalized()
    var deaccelDir = dir

    if (advance) {
      if (dir.dot(lv) < maxSpeed) {
        lv += dir * accel * delta
      }
      deaccelDir = dir.cross(g).normalized()
    } else {
      if (prevAdvance) {
        rotDir = 1
      }

      dir = Basis(up, rotDir * rotSpeed * delta).xform(dir)
      armature.transform = Transform().lookingAt(-dir, up)
    }

    var dspeed = deaccelDir.dot(lv)
    dspeed -= deaccel * delta
    if (dspeed < 0f) {
      dspeed = 0f
    }

    lv -= deaccelDir * deaccelDir.dot(lv) + deaccelDir * dspeed

    state.linearVelocity = lv
    prevAdvance = advance
  }

  fun _die() {
    queueFree()
  }

  companion object : GodotClass<RigidBody, Enemy>(::Enemy) {
    override fun init(registry: ClassMemberRegistry<Enemy>) {
      with(registry) {
        registerMethod(Enemy::_integrate_forces)
        registerMethod(Enemy::_die)
      }
    }

    const val STATE_WALING = 0
    const val STATE_DYING = 1
  }
}