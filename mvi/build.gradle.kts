plugins {
    // Android library
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.brbx.mvi"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }
    defaultConfig { minSdk = 28 }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
            freeCompilerArgs.add("-Xcontext-parameters")
        }
    }
}

dependencies {

    // Core
    implementation(project(":core"))

    // ViewModel Lifecycle
    api(libs.androidx.lifecycle.viewmodel.ktx)
}