plugins {
    id("traveller.android.library")
    id("traveller.android.library.compose")
    kotlin("kapt")
}

android {
    namespace = "com.modernunit.featureSplash"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(project(":core-ui"))
    implementation(project(":core-data"))
    implementation(project(":core-testing"))

    implementation(libs.org.jetbrains.kotlinx.coroutines.android)
    implementation(libs.com.google.hilt)
    kapt(libs.com.google.hilt.compiler)

    implementation(libs.androidx.hilt.navigation.compose)

    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.common)
    implementation(libs.androidx.lifecycle.process)
}