
val compositeBuild: String by settings

if (compositeBuild == "true") {
  includeBuild("../godot-kotlin") {
    dependencySubstitution {
      substitute(module("com.github.raniejade:godot-kotlin-gradle-plugin")).with(project(":godot-kotlin-gradle-plugin"))
      substitute(module("com.github.raniejade:godot-kotlin")).with(project(":godot-kotlin"))
    }
  }

}

pluginManagement {
  val godotKotlinVersion: String by settings
  val compositeBuild: String by settings

  if (compositeBuild == "true") {
    resolutionStrategy.eachPlugin {
      if (requested.id.id == "com.github.raniejade.godot-kotlin") {
        useModule("com.github.raniejade:godot-kotlin-gradle-plugin:$godotKotlinVersion")
      }
    }
  }
}

include("3d-platformer")

