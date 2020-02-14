// uncomment to use local copy of godot-kotlin
//includeBuild("../godot-kotlin") {
//  dependencySubstitution {
//    substitute(module("com.github.raniejade:godot-kotlin-gradle-plugin:0.1.0")).with(project(":godot-kotlin-gradle-plugin"))
//    substitute(module("com.github.raniejade:godot-kotlin")).with(project(":godot-kotlin"))
//  }
//}

pluginManagement {
  val godotKotlinVersion: String by settings
  resolutionStrategy.eachPlugin {
    if (requested.id.id == "com.github.raniejade.godot-kotlin") {
      useModule("com.github.raniejade:godot-kotlin-gradle-plugin:$godotKotlinVersion")
    }
  }

  repositories {
    // plugin is not available in gradlePluginPortal yet
    // maven("https://dl.bintray.com/raniejade/godot-kotlin")
    // dev builds
    maven("https://dl.bintray.com/raniejade/godot-kotlin-dev")
    jcenter()
  }
}

include("3d-platformer")

