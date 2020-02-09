import godot.*
import godot.core.Basis
import godot.core.VariantArray
import godot.core.Vector3

class FollowCamera : Camera() {
  private val collisionExceptions = VariantArray()

  var minDistance by floatProperty()
  var maxDistance by floatProperty()
  var angleVAdjust by floatProperty()
  var autoturnRayAperture by floatProperty()
  var autoturnSpeed by floatProperty()

  private val maxHeight = 2f
  private val minHeight = 0f

  fun _physics_process(dt: Float) {
    val target = getParent<Spatial>().globalTransform.origin
    var pos = globalTransform.origin
    val up = Vector3(0f, 1f, 0f)

    var delta = pos - target

    // check ranges
    if (delta.length() < minDistance) {
      delta = delta.normalized() * minDistance
    } else if (delta.length() > maxDistance) {
      delta = delta.normalized() * maxDistance
    }

    // check upper and lower height
    if (delta.y > maxHeight) {
      delta.y = maxHeight
    }
    if (delta.y < minHeight) {
      delta.y = minHeight
    }

    // Check autoturn
    val ds = PhysicsServer.spaceGetDirectState(getWorld().space)

    val colLeft = ds.intersectRay(target, target + Basis(up, deg2rad(autoturnRayAperture)).xform(delta), collisionExceptions)
    val col = ds.intersectRay(target, target + delta, collisionExceptions)
    val colRight = ds.intersectRay(target, Basis(up, deg2rad(-autoturnRayAperture)).xform(delta), collisionExceptions)

    if (!col.empty()) {
      // If main ray was occluded, get camera closer, this is the worst case scenario
      delta = col["position"].asVector3() - target
    } else if (!colLeft.empty() && colRight.empty()) {
      // If only left ray is occluded, turn the camera around to the right
      delta = Basis(up, deg2rad(-dt * autoturnSpeed)).xform(delta)
    } else if (colLeft.empty() && !colRight.empty()) {
      // If only right ray is occluded, turn the camera around to the left
      delta = Basis(up, deg2rad(dt * autoturnSpeed)).xform(delta)
    } else {
      // Do nothing otherwise, left and right are occluded but center is not, so do not autoturn
    }

    // Apply lookat
    if (delta == Vector3()) {
      delta = (pos - target).normalized() * 0.0001f
    }

    pos = target + delta

    lookAtFromPosition(pos, target, up)

    // Turn a little up or down
    val t = transform
    t.basis = Basis(t.basis[0], deg2rad(angleVAdjust)) * t.basis
    transform = t

    // alternative
    // transform {
    //  basis = Basis(t.basis[0], angleVAdjust.toDegrees().toFloat()) * t.basis
    // }
  }

  fun _ready() {
    // Find collision exceptions for ray
    var node: Node? = this
    while (node != null) {
      if (node is RigidBody) {
        collisionExceptions.append(node.getRid())
        break
      } else {
        node = node.getParent()
      }
    }

    setPhysicsProcess(true)
    // This detaches the camera transform from the parent spatial node
    setAsToplevel(true)
  }

  companion object : GodotClass<Camera, FollowCamera>(::FollowCamera) {
    override fun init(registry: ClassMemberRegistry<FollowCamera>) {
      with(registry) {
        registerProperty(FollowCamera::minDistance, default = 0.5f)
        registerProperty(FollowCamera::maxDistance, default = 3.5f)
        registerProperty(FollowCamera::angleVAdjust)
        registerProperty(FollowCamera::autoturnRayAperture, default = 25f)
        registerProperty(FollowCamera::autoturnSpeed, default = 50f)
        registerMethod(FollowCamera::_ready)
        registerMethod(FollowCamera::_physics_process)
      }
    }
  }
}