plugins {
    // Android library
    alias(libs.plugins.android.library)
    // Compose
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.brbx.ui_compose"
    compileSdk = 37
    defaultConfig { minSdk = 28 }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures { compose = true }
}

dependencies {

    // Core
    implementation(project(":core"))

    // Compose
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.ui.graphics)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.animation.graphics)
    api(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)
    // Coil
    implementation(libs.coil.compose)
    // Solar icons
    implementation(libs.solar)
}