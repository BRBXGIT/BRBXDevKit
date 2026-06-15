plugins {
    // Android library
    alias(libs.plugins.android.library)
    // Compose
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.brbx.coroutines_helpers"
    compileSdk = 37
    defaultConfig { minSdk = 28 }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures { compose = true }
    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
            freeCompilerArgs.add("-Xcontext-parameters")
        }
    }
}

dependencies {

    // Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    // Lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx)
}