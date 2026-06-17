plugins {
    // Android library
    alias(libs.plugins.brbxdevkit.android.library)
    // Publishing
    alias(libs.plugins.brbxdevkit.maven.publish)
}

dependencies {

    // Lifecycle
    api(libs.androidx.lifecycle.runtime.ktx)
}