plugins {
    // Android library
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.brbx.mvi"
    compileSdk = 37
    defaultConfig { minSdk = 28 }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
            freeCompilerArgs.add("-Xcontext-parameters")
        }
    }
}

dependencies {

    // ViewModel Lifecycle
    api(libs.androidx.lifecycle.viewmodel.ktx)
}