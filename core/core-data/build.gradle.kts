plugins {
    id("traveller.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "com.modernunit.data"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(project(":core:core-network"))
    implementation(project(":core:core-testing"))

    implementation(libs.com.google.hilt)
    kapt(libs.com.google.hilt.compiler)
}