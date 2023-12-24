object Version {
    const val material = "1.10.0"
    const val appCompat = "1.6.1"
    const val core = "1.12.0"
    const val runtime = "2.6.2"
    const val compose = "1.8.2"
    const val junit = "4.13.2"
    const val testJunit = "1.1.5"
    const val expressoCore = "3.5.1"
    const val composeBom = "2023.03.00"

    const val retrofit = "2.9.0"
    const val gsonConvertor = "2.9.0"
    const val okHttp = "4.9.0"
    const val scalerConvertor = "2.1.0"

    const val dagger = "2.44"
    const val hiltCompiler = "1.0.0"
    const val hiltComposeNavigation = "1.0.0"


    // compose
    const val composeUiVersion = "1.3.3"
    const val composeActivity = "1.6.1"
    const val composeMaterial = "1.3.1"

    const val composeNavigation = "2.6.0-alpha05"

    const val coilImageLoading = "2.2.2"
}

object Deps {
    const val material = "com.google.android.material:material:${Version.material}"
    const val core = "androidx.core:core-ktx:${Version.core}"
    const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.runtime}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val compose = "androidx.activity:activity-compose:${Version.compose}"
    const val composeBom = "androidx.compose:compose-bom:${Version.composeBom}"
    const val composeUI = "androidx.compose.ui:ui"
    const val composeUIGraphoicks = "androidx.compose.ui:ui-graphics"
    const val composeUIPreview = "androidx.compose.ui:ui-tooling-preview"
    const val material3 = "androidx.compose.material3:material3"
    const val junit = "junit:junit:${Version.junit}"
    const val androidTestJunit = "androidx.test.ext:junit:${Version.testJunit}"
    const val expressoCore = "androidx.test.espresso:espresso-core:${Version.expressoCore}"
    const val composeBomAndroidTest = "androidx.compose:compose-bom:${Version.composeBom}"
    const val composeJunitAndroidTest = "androidx.compose.ui:ui-test-junit4"
    const val composeToolingDebug = "androidx.compose.ui:ui-tooling"
    const val composeManifestDebug = "androidx.compose.ui:ui-test-manifest"
}

object DaggerHilt {
    const val hilt = "com.google.dagger:hilt-android:${Version.dagger}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Version.dagger}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Version.dagger}"
    const val hiltComposeNavigation =
        "androidx.hilt:hilt-navigation-compose:${Version.hiltComposeNavigation}"
}


object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val gsonConvertor = "com.squareup.retrofit2:converter-gson:${Version.gsonConvertor}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Version.okHttp}"
    const val scalersConvertors =
        "com.squareup.retrofit2:converter-scalars:${Version.scalerConvertor}"
}

object JetpackCompose {
    const val composeActivity = "androidx.activity:activity-compose:${Version.composeActivity}"
    const val composeUi = "androidx.compose.ui:ui:${Version.composeUiVersion}"
    const val composeUiToolingPreview =
        "androidx.compose.ui:ui-tooling-preview:${Version.composeUiVersion}"
    const val composeMaterial = "androidx.compose.material:material:${Version.composeMaterial}"
    const val navigation = "androidx.navigation:navigation-compose:${Version.composeNavigation}"
}