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
    api(project(":core:core-designsystem"))
    implementation(project(":core:core-testing"))

    api(libs.androidx.metrics)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material)
    api(libs.androidx.compose.ui.tooling)
    api(libs.com.google.accompanist.insets.ui)
    api(libs.com.google.accompanist.swiperefresh)
    api(libs.com.google.accompanist.permissions)

    api(libs.org.jetbrains.kotlinx.collections.immutable)

    testImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // TODO : Remove these dependency once we upgrade to Android Studio Dolphin b/228889042
    // These dependency are currently necessary to render Compose previews
    debugImplementation(libs.androidx.customview.poolingcontainer)
}