plugins {
    // Compose android library
    alias(libs.plugins.brbxdevkit.compose.android.library)
    // Publishing
    alias(libs.plugins.brbxdevkit.android.publish)
}

dependencies {

    // Coil
    api(libs.coil.compose)
}