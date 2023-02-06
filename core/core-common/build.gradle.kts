plugins {
    id("traveller.android.library")
    id("traveller.android.library.compose")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "com.modernunit.common"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(project(":core:core-testing"))

    implementation(libs.org.jetbrains.kotlinx.coroutines.core)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui)

    implementation(libs.com.google.hilt)
    kapt(libs.com.google.hilt.compiler)
}