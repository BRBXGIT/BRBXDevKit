plugins {
    // Application
    alias(libs.plugins.android.application)
    // Compose
    alias(libs.plugins.kotlin.compose)
    // Serialization
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.brbx.brbxdevkit"
    compileSdk = 37
    defaultConfig {
        applicationId = "com.brbx.brbxdevkit"
        minSdk = 28
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    // Modules
    implementation(project(":mvi-compose"))

    // Core
    implementation(libs.androidx.core.ktx)
    // Solar
    implementation(libs.solar)
    // Koin
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)
}