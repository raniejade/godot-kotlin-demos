import godot.GodotClass
import godot.RigidBody

class Bullet : RigidBody() {
  var disabled = false

  companion object : GodotClass<RigidBody, Bullet>(::Bullet)
}