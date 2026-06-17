package com.brbx.convention

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

abstract class BaseAndroidLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")
            applyExtraPlugins()

            extensions.configure<LibraryExtension> {
                val modulePath = project.path
                    .split(":")
                    .filter { it.isNotEmpty() }
                    .joinToString(separator = ".") { it.replace("-", "_") }
                namespace = if (modulePath.isNotEmpty()) {
                    "com.brbx.$modulePath"
                } else "com.brbx"

                compileSdk = 37
                defaultConfig.minSdk = 28
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }

                publishing {
                    singleVariant("release") {
                        withSourcesJar()
                        withJavadocJar()
                    }
                }

                configureExtraConfiguration(this@with)
            }
        }
    }

    protected open fun LibraryExtension.configureExtraConfiguration(project: Project) {}
    protected open fun Project.applyExtraPlugins() {}
}