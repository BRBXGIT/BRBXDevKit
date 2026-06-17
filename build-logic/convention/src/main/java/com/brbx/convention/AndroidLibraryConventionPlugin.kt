package com.brbx.convention

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")

            extensions.configure<LibraryExtension> {
                val modulePath = project.path
                    .split(":")
                    .filter { it.isNotEmpty() }
                    .joinToString(".") { it.replace("-", "") }
                namespace = if (modulePath.isNotEmpty()) {
                    "com.brbx.$modulePath"
                } else {
                    "com.brbx"
                }

                compileSdk = 37
                defaultConfig.minSdk = 28
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }
                publishing {
                    singleVariant("release") {
                        withSourcesJar()
                    }
                }
            }
        }
    }
}