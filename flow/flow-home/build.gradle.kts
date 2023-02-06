plugins {
    id("traveller.android.library")
    id("traveller.android.library.compose")
}

android {
    namespace = "com.modernunit.homeFlow"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(project(":core:core-ui")) //todo remove it later
    implementation(project(":core:core-testing"))

    implementation(libs.androidx.navigation.compose)
}