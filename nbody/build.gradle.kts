plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.41")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.processing:core:3.3.6")
    implementation("net.compartmental.code:minim:2.2.2")
/*
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
*/
}

application {
    // Define the main class for the application.
    mainClassName = "NbodyKt"
}
