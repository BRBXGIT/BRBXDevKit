plugins {
    // Kotlin jvm
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

kotlin {
    jvmToolchain(jdkVersion = 17)

    compilerOptions {
        freeCompilerArgs.add("-Xcontext-parameters")
    }
}

dependencies {

    // Lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx)
}