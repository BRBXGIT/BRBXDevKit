plugins {
    // Android library
    alias(libs.plugins.android.library)
    // Compose
    alias(libs.plugins.kotlin.compose)
    // Maven
    `maven-publish`
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
    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
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

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.BRBXGIT"
                artifactId = "ui-compose"
                version = "1.0.0"
            }
        }
    }
}