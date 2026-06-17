plugins {
    // Compose android library
    alias(libs.plugins.brbxdevkit.compose.android.library)
    // Publishing
    alias(libs.plugins.brbxdevkit.android.publish)
}

dependencies {

    // Compose
    api(platform(libs.androidx.compose.bom))
    api(libs.bundles.compose.core)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)
    // Solar icons
    implementation(libs.solar)
}