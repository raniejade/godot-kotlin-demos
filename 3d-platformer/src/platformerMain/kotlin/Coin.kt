import godot.*
import godot.core.NodePath

class Coin : Area() {
  private var taken = false

  fun onCoinBodyEntered(node: Node) {
    if (!taken && node is Player) {
      (getNode(NodePath("anim")) as AnimationPlayer).play("take")
      taken = true
    }
  }

  companion object : GodotClass<Area, Coin>(::Coin) {
    override fun init(registry: ClassMemberRegistry<Coin>) {
      registry.registerMethod(Coin::onCoinBodyEntered)
    }
  }
}