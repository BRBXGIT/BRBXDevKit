plugins {
    // Kotlin jvm
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

kotlin {
    jvmToolchain(jdkVersion = 17)
}

dependencies {

    // Lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx)
}