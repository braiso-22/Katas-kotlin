plugins {
    kotlin("jvm") version "1.9.23"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("com.google.truth:truth:1.4.2")
    testImplementation(kotlin("test"))
    testImplementation("junit:junit:4.13.2")
}
kotlin {
    jvmToolchain(17)
}