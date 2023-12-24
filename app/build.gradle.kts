import Deps.composeManifestDebug
import Deps.composeToolingDebug

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")

}

android {
    namespace = "com.example.multimoduleapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.multimoduleapp"
        minSdk = 29
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = "18"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":feature:movie:data"))
    implementation(project(":feature:movie:domain"))
    implementation(project(":feature:movie:ui"))

    implementation(project(":feature:movie_detail:data"))
    implementation(project(":feature:movie_detail:domain"))
    implementation(project(":feature:movie_detail:ui"))
    implementation(project(":core:feature_api"))


    implementation (Deps.core)
    implementation(Deps.runtime)
    implementation(Deps.compose)
    implementation(platform(Deps.composeBom))
    implementation(Deps.composeUI)
    implementation(Deps.composeUIGraphoicks)
    implementation(Deps.composeUIPreview)
    implementation(JetpackCompose.navigation)
    implementation(Deps.material3)
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.androidTestJunit)
    androidTestImplementation(Deps.expressoCore)
    androidTestImplementation(platform(Deps.composeBomAndroidTest))
    androidTestImplementation(Deps.composeJunitAndroidTest)
    debugImplementation(composeToolingDebug)
    debugImplementation(composeManifestDebug)

    implementation(DaggerHilt.hilt)
    kapt(DaggerHilt.hiltCompiler)
}