import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.example.build_logic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidLibrary") {
            id = libs.plugins.brbxdevkit.android.library.get().pluginId
            implementationClass = "com.brbx.convention.plugins.AndroidLibraryConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = libs.plugins.brbxdevkit.compose.android.library.get().pluginId
            implementationClass = "com.brbx.convention.plugins.ComposeAndroidLibraryConventionPlugin"
        }

        register("androidLibraryMavenPublish") {
            id = libs.plugins.brbxdevkit.maven.publish.get().pluginId
            implementationClass = "com.brbx.convention.plugins.MavenPublishConventionPlugin"
        }
    }
}