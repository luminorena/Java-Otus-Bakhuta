import org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES
import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel

plugins {
    idea
    id("io.spring.dependency-management")
    id("org.springframework.boot") apply false
    id("com.diffplug.spotless")
}

idea {
    project {
        languageLevel = IdeaLanguageLevel(17)
    }
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}


allprojects {
    group = "org.tasks"

    repositories {
        mavenLocal()
        mavenCentral()
    }

    val guava: String by project


    apply(plugin = "io.spring.dependency-management")
    dependencyManagement {
        dependencies {
            imports {
                mavenBom(BOM_COORDINATES)
            }
            dependency("com.google.guava:guava:$guava")
        }
    }

    configurations.all {
        resolutionStrategy {
            failOnVersionConflict()

        }
    }
}

subprojects {
    plugins.apply(JavaPlugin::class.java)
    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    apply<com.diffplug.gradle.spotless.SpotlessPlugin>()
    configure<com.diffplug.gradle.spotless.SpotlessExtension> {
        java {
            googleJavaFormat("1.16.0").aosp()
        }
    }

}

