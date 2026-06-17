package com.brbx.convention

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.get

class AndroidLibraryMavenPublishConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("maven-publish")

            afterEvaluate {
                extensions.configure<PublishingExtension> {
                    publications {
                        create<MavenPublication>("release") {
                            from(components["release"])
                            groupId = "com.github.BRBXGIT"
                            artifactId = project.name
                            version = "1.0.0"
                        }
                    }
                }
            }
        }
    }
}