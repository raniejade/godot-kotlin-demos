plugins {
  kotlin("multiplatform")
  id("com.github.raniejade.godot-kotlin")
}

godot {
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