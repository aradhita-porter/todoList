
val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "1.8.10"
    id("io.ktor.plugin") version "2.3.5"
    kotlin("kapt") version "1.5.20"
    kotlin("plugin.serialization") version "1.5.31"
}

kapt {
    useBuildCache = true // Enable build cache (optional)
    correctErrorTypes = true
    arguments {
        arg("dagger.hilt.processor.verbose", "true") // Enable verbose logging for Dagger/Hilt (optional)
    }
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("com.example.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    implementation("org.jetbrains.exposed:exposed-core:0.35.1")
    implementation ("org.jetbrains.exposed:exposed-dao:0.35.1")
    implementation ("org.jetbrains.exposed:exposed-jdbc:0.35.1")
    implementation ("org.postgresql:postgresql:42.2.2")
    implementation("org.postgresql:postgresql:42.2.19")
    implementation ("javax.inject:javax.inject:1")
    implementation ("joda-time:joda-time:2.10.12")
    implementation("com.google.dagger:dagger:2.45")
    implementation("com.google.dagger:dagger-compiler:2.45")
    kapt("com.google.dagger:dagger-compiler:2.45")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.0")
    implementation("io.ktor:ktor-serialization:$ktor_version")
    implementation("io.ktor:ktor-jackson:1.6.0")
    implementation("io.ktor:ktor-client-cio:1.6.0")
    implementation("io.ktor:ktor-client-json:1.6.0")
    implementation("io.ktor:ktor-server-sessions:1.6.0")
    implementation("io.ktor:ktor-features:1.6.8")
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("org.jetbrains.exposed:exposed-java-time:0.38.2")
    implementation("org.jetbrains.exposed:exposed-core:0.38.2") // Replace with the appropriate version
    implementation("org.jetbrains.exposed:exposed-dao:0.38.2")
    implementation ("joda-time:joda-time:2.10.14")
    implementation("org.mindrot:jbcrypt:0.4")

}
