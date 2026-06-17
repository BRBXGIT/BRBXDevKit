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

            extensions.configure<PublishingExtension> {
                // Android library publishing
                pluginManager.withPlugin("com.android.library") {
                    afterEvaluate {
                        publications.create<MavenPublication>("release") {
                            from(components["release"])
                            groupId = "com.github.BRBXGIT.BRBXDevKit"
                            artifactId = project.name
                            version = "1.0.44"
                        }
                    }
                }

                // Kotlin/java module publishing
                pluginManager.withPlugin("org.jetbrains.kotlin.jvm") {
                    publications.create<MavenPublication>("java") {
                        from(components["java"])
                        groupId = "com.github.BRBXGIT.BRBXDevKit"
                        artifactId = project.name
                        version = "1.0.44"
                    }
                }
            }
        }
    }
}