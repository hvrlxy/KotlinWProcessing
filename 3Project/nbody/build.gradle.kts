plugins {
  kotlin"jvm" version "1.3.50"
  application
}

repositories {
    mavenCentral()
    jcenter()
    google()
}

dependencies {
    // implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.processing:core:3.3.6")
    implementation("net.compartmental.code:minim:2.2.2")
}

application {
    // Define the main class for the application.
    mainClassName = "NbodyKt"
}

