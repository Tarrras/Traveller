plugins {
    id("traveller.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "com.modernunit.background"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(libs.org.jetbrains.kotlinx.coroutines.core)
    implementation(libs.com.google.hilt)
    kapt(libs.com.google.hilt.compiler)
}