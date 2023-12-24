plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.feature.movie.ui"
    compileSdk = 34

    defaultConfig {
        minSdk = 29

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    implementation(project(":core:feature_api"))
    implementation(project(":feature:movie:domain"))

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
    debugImplementation(Deps.composeToolingDebug)
    debugImplementation(Deps.composeToolingDebug)
    debugImplementation(DaggerHilt.hiltComposeNavigation)
    implementation("io.coil-kt:coil-compose:2.4.0")


    implementation(JetpackCompose.navigation)
    implementation(DaggerHilt.hilt)
    kapt(DaggerHilt.hiltCompiler)
}