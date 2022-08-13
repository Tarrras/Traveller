plugins {
    id("traveller.android.library")
    id("traveller.android.library.compose")
}

android {
    namespace = "com.modernunit.authentication"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(project(":feature-intro"))
    implementation(project(":feature-login"))
    implementation(project(":feature-registration"))
    implementation(project(":feature-welcome"))
    implementation(libs.androidx.navigation.compose)
}