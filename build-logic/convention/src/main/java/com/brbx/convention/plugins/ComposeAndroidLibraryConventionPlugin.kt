package com.brbx.convention.plugins

import com.android.build.api.dsl.LibraryExtension
import com.brbx.convention.BaseAndroidLibraryConventionPlugin
import org.gradle.api.Project

class ComposeAndroidLibraryConventionPlugin : BaseAndroidLibraryConventionPlugin() {

    override fun Project.applyExtraPlugins() {
        pluginManager.apply("org.jetbrains.kotlin.plugin.compose")
    }

    override fun LibraryExtension.configureExtraConfiguration(project: Project) {
        buildFeatures { compose = true }
    }
}