plugins {
    id("traveller.android.library")
    id("traveller.android.library.compose")
    kotlin("kapt")
}

android {
    namespace = "com.modernunit.testing"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(libs.com.google.hilt)
    api(libs.com.google.hilt.testing)
    kapt(libs.com.google.hilt.compiler)

    api(libs.org.jetbrains.kotlinx.coroutines.test)

    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.runner)
    api(libs.androidx.test.rules)
    api(libs.androidx.compose.ui.test.junit4)
    api(libs.androidx.compose.ui.test.manifest)
    api(libs.androidx.room.testing)

    api(libs.junit)
    api(libs.turbine)
    api(libs.androidx.test.core.ktx)
    api(libs.androidx.test.ext.junit.ktx)
    api(libs.androidx.test.rules)
    api(libs.androidx.test.ext.truth)
    testApi(libs.androidx.arch.core.testing)

    androidTestApi(libs.androidx.test.runner)
    androidTestApi(libs.androidx.test.ext.junit.ktx)
    androidTestApi(libs.androidx.test.espresso.core)
}
