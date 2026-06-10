plugins {
    // Application
    alias(libs.plugins.android.application)
    // Compose
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.brbx.brbxdevkit"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }
    defaultConfig {
        applicationId = "com.brbx.brbxdevkit"
        minSdk = 28
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(project(":mvi-compose"))
    implementation(project(":ui-compose"))

    // Core
    implementation(libs.androidx.core.ktx)

    // Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
}