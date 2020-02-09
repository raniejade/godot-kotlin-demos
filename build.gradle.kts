buildscript {
  repositories {
    // plugin is not available in gradlePluginPortal yet
    maven("https://dl.bintray.com/raniejade/godot-kotlin")
    jcenter()
  }

  dependencies {
    classpath(kotlin("gradle-plugin", version = "1.3.61"))
    classpath("com.github.raniejade:godot-kotlin-gradle-plugin:32.1.0-rc.2")
  }
}

subprojects {
  repositories {
    // godot-kotlin artifacts are not in jcenter yet
    maven("https://dl.bintray.com/raniejade/godot-kotlin")
    jcenter()
  }
}