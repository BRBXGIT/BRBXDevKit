plugins {
    // Compose android library
    alias(libs.plugins.brbxdevkit.compose.android.library)
    // Publishing
    alias(libs.plugins.brbxdevkit.maven.publish)
}

dependencies {

    // Modules
    api(project(":mvi"))
    api(project(":ui-compose"))

    // Navigation
    api(libs.navigation.compose)
}