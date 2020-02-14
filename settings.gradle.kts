includeBuild("../godot-kotlin") {
  dependencySubstitution {
    substitute(module("com.github.raniejade:godot-kotlin-gradle-plugin:0.1.0")).with(project(":godot-kotlin-gradle-plugin"))
    substitute(module("com.github.raniejade:godot-kotlin")).with(project(":godot-kotlin"))
  }
}


include("3d-platformer")

pluginManagement {
  resolutionStrategy.eachPlugin {
    if (requested.id.id == "com.github.raniejade.godot-kotlin") {
      useModule("com.github.raniejade:godot-kotlin-gradle-plugin:0.1.0")
    }
  }
}