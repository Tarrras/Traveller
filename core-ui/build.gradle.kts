plugins {
    id("traveller.android.library")
    id("traveller.android.library.compose")
}

android {
    namespace = "com.modernunit.coreUi"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(project(":core-designsystem"))
    implementation(libs.androidx.metrics)
    testImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // TODO : Remove these dependency once we upgrade to Android Studio Dolphin b/228889042
    // These dependency are currently necessary to render Compose previews
    debugImplementation(libs.androidx.customview.poolingcontainer)
}