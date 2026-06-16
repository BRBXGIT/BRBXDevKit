plugins {
    // Android library
    alias(libs.plugins.android.library)
    // Compose
    alias(libs.plugins.kotlin.compose)
    // Maven
    `maven-publish`
}

android {
    namespace = "com.brbx.mvi_compose"
    compileSdk = 37
    defaultConfig { minSdk = 28 }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures { compose = true }
    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

dependencies {

    // Modules
    api(project(":mvi"))
    api(project(":ui-compose"))

    // Navigation
    api(libs.navigation.compose)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.BRBXGIT"
                artifactId = "mvi-compose"
                version = "1.0.0"
            }
        }
    }
}