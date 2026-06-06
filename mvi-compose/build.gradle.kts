plugins {
    // Android
    alias(libs.plugins.android.library)
    // Compose
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.brbx.mvi_compose"
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
    buildFeatures { compose = true }
}

dependencies {

    // Lifecycle
    api(libs.androidx.lifecycle.runtime.ktx)
    // Compose
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.compose.ui)
}