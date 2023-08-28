import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id ("com.github.johnrengelman.shadow")
}

val faker: String by project

dependencies {
    implementation("com.github.javafaker:javafaker:$faker")
}


tasks {
    named<ShadowJar>("shadowJar") {
        archiveBaseName.set("gradleHelloWorld")
        archiveVersion.set("0.1")
        archiveClassifier.set("")
        manifest {
            attributes(mapOf("Main-Class" to "org.tasks.HelloOtus"))
        }
    }

    build {
        dependsOn(shadowJar)
    }
}