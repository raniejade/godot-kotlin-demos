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