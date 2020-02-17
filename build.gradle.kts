plugins {
  id("com.github.raniejade.godot-kotlin") version "32.1.0" apply false
}

buildscript {
  repositories {
    jcenter()
  }

  dependencies {
    classpath(kotlin("gradle-plugin", version = "1.3.61"))
  }
}

subprojects {
  repositories {
    // dev builds
    // maven("https://dl.bintray.com/raniejade/godot-kotlin-dev")
    jcenter()
  }
}