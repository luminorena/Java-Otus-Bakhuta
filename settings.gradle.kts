rootProject.name = "Java-Otus-Bakhuta"
include("hw01-gradle")


pluginManagement {
    val dependencyManagement: String by settings
    val springframeworkBoot: String by settings
    val johnrengelmanShadow: String by settings
    val spotless: String by settings

    plugins {
        id("io.spring.dependency-management") version dependencyManagement
        id("org.springframework.boot") version springframeworkBoot
        id("com.github.johnrengelman.shadow") version johnrengelmanShadow
        id("com.diffplug.spotless") version spotless
    }
}
include("hw05-aspects")
