plugins {
    // Android library
    alias(libs.plugins.android.library)
    // Maven
    `maven-publish`
}

android {
    namespace = "com.brbx.mvi"
    compileSdk = 37
    defaultConfig { minSdk = 28 }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

dependencies {

    // ViewModel Lifecycle
    api(libs.androidx.lifecycle.viewmodel.ktx)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.BRBXGIT"
                artifactId = "mvi"
                version = "1.0.0"
            }
        }
    }
}