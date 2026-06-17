package com.brbx.convention.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.get

class MavenPublishConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("maven-publish")

            group = "com.github.BRBXGIT.BRBXDevKit"
            version = System.getenv("JITPACK_VERSION") ?: "1.0.44-LOCAL"

            tasks.withType(
                org.gradle.api.publish.tasks.GenerateModuleMetadata::class.java
            ).configureEach {
                enabled = false
            }

            extensions.configure<PublishingExtension> {
                pluginManager.withPlugin("com.android.library") {
                    afterEvaluate {
                        publications.create<MavenPublication>("release") {
                            from(components["release"])
                            artifactId = project.name
                        }
                    }
                }

                pluginManager.withPlugin("org.jetbrains.kotlin.jvm") {
                    publications.create<MavenPublication>("java") {
                        from(components["java"])
                        artifactId = project.name
                    }
                }
            }
        }
    }
}