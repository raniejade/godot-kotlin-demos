plugins {
  kotlin("multiplatform")
  id("com.github.raniejade.godot-kotlin")
}

val compositeBuild: String by project

godot {
  libraries {
    val platformer by creating {
      isCompositeBuild.set(compositeBuild == "true")
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