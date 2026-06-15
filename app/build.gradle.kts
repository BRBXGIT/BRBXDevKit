plugins {
    // Application
    alias(libs.plugins.android.application)
    // Compose
    alias(libs.plugins.kotlin.compose)
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

    implementation(project(":mvi"))
    implementation(project(":ui-compose"))

    // Core
    implementation(libs.androidx.core.ktx)

    // Solar
    implementation(libs.solar)
}