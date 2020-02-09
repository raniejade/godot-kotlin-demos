plugins {
  kotlin("multiplatform")
  id("com.github.raniejade.godot-kotlin")
}

godot {
  isCompositeBuild.set(true)
  libraries {
    val platformer by creating {
      classes(
        "Bullet",
        "Coin",
        "Enemy",
        "FollowCamera",
        "Player"
      )
    }
  }
}