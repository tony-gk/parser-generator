import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.20"
}

group = "ru.itmo.gunkin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.antlr:antlr4-runtime:4.9")
    testImplementation(kotlin("test-junit"))
    testImplementation("org.junit.platform:junit-platform-launcher:1.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    testImplementation("org.junit.vintage:junit-vintage-engine:5.7.0")
}

sourceSets {
    main {
        java.srcDir("src/main/java")
    }
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}