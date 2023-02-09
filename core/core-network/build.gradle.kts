plugins {
    id("traveller.android.library")
    id("com.google.gms.google-services")
    id("dagger.hilt.android.plugin")
    id("kotlinx-serialization")
    kotlin("kapt")
}

android {
    namespace = "com.modernunit.network"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(project(":core:core-testing"))

    api(libs.androidx.collection.ktx)
    api(libs.org.jetbrains.kotlinx.coroutines.core)
    api(libs.org.jetbrains.kotlinx.coroutines.android)
    implementation(libs.org.jetbrains.kotlinx.coroutines.play.services)
    testImplementation(libs.org.jetbrains.kotlinx.coroutines.test)
    api(libs.com.google.code.gson)
    api(libs.org.jetbrains.kotlinx.serialization.json)
    api(libs.org.jetbrains.kotlinx.datetime)

    implementation(libs.com.squareup.okhttp3.okhttp)
    implementation(libs.com.squareup.okhttp3.logging.interceptor)

    implementation(libs.com.squareup.retrofit2.retrofit)
    implementation(libs.com.squareup.retrofit2.converter.gson)

    implementation(libs.com.squareup.curtains)

    implementation(libs.com.google.firebase.core)
    implementation(libs.com.google.firebase.auth)

    implementation(libs.com.google.hilt)
    kapt(libs.com.google.hilt.compiler)
}
