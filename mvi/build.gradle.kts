plugins {
    // Android library
    alias(libs.plugins.brbxdevkit.android.library)
    // Publishing
    alias(libs.plugins.brbxdevkit.maven.publish)
}

dependencies {

    // ViewModel Lifecycle
    api(libs.androidx.lifecycle.viewmodel.ktx)
}