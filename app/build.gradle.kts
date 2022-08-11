plugins {
    id("traveller.android.application")
    id("traveller.android.application.compose")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("org.owasp.dependencycheck")
    id("kotlinx-serialization")
    id("com.google.devtools.ksp")
    id("com.google.gms.google-services")
    id("com.github.ben-manes.versions")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.modernunit.traveller"

    defaultConfig {
        applicationId = "com.modernunit.traveller"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.org.jetbrains.kotlin.stdlib.jdk8)
    implementation(libs.org.jetbrains.kotlin.reflect)
    testImplementation(libs.org.jetbrains.kotlin.test.junit)

    implementation(libs.org.jetbrains.kotlinx.coroutines.core)
    implementation(libs.org.jetbrains.kotlinx.coroutines.android)
    implementation(libs.org.jetbrains.kotlinx.coroutines.play.services)
    testImplementation(libs.org.jetbrains.kotlinx.coroutines.test)

    implementation(libs.androidx.annotation)
    implementation(libs.androidx.core.ktx)

    implementation(libs.androidx.collection.ktx)

    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.common)
    implementation(libs.androidx.lifecycle.process)

    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.fragment.ktx)

    implementation(libs.androidx.navigation.compose)

    implementation(libs.androidx.appcompat)
    implementation(libs.com.google.android.material)
    implementation(libs.androidx.constraintlayout.compose)

    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.paging)
    testImplementation(libs.androidx.room.testing)

    implementation(libs.androidx.datastore.preferences)

    implementation(libs.androidx.hilt.worker)

    implementation(libs.com.google.code.gson)
    implementation(libs.org.jetbrains.kotlinx.serialization.json)
    implementation(libs.org.jetbrains.kotlinx.datetime)

    implementation(libs.com.google.hilt)
    implementation(libs.androidx.hilt.navigation.compose)
    kapt(libs.com.google.hilt.compiler)
    kapt(libs.androidx.hilt.compiler)

    implementation(libs.com.squareup.okhttp3.okhttp)
    implementation(libs.com.squareup.okhttp3.logging.interceptor)

    implementation(libs.com.squareup.retrofit2.retrofit)
    implementation(libs.com.squareup.retrofit2.converter.gson)

    implementation(libs.com.squareup.curtains)

    implementation(libs.com.airbnb.android.lottie.compose)

    implementation(libs.com.google.firebase.core)
    implementation(libs.com.google.firebase.auth)

    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.runtime.runtime.livedata)
    implementation(libs.androidx.compose.ui.tooling)
    testImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    implementation(libs.com.google.accompanist.insets.ui)
    implementation(libs.com.google.accompanist.swiperefresh)
    implementation(libs.com.google.accompanist.permissions)

    implementation(libs.com.valentinilk.shimmer.compose)

    testImplementation(libs.junit)
    testImplementation(libs.androidx.test.core.ktx)
    testImplementation(libs.androidx.test.ext.junit.ktx)
    testImplementation(libs.androidx.test.rules)
    testImplementation(libs.androidx.test.ext.truth)
    testImplementation(libs.androidx.arch.core.testing)

    testImplementation(libs.org.robolectric)

    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.androidx.test.ext.junit.ktx)
    androidTestImplementation(libs.androidx.test.espresso.core)
}


kapt {
    javacOptions {
        // Increase the max count of errors from annotation processors.
        // Default is 100.
        option("-Xmaxerrs", 500)
    }
}

ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
}

hilt {
    enableAggregatingTask = true
}

dependencyCheck {
    scanConfigurations = listOf(
        "prodSecureRestrictedReleaseCompileClasspath", "prodSecureRestrictedReleaseRuntimeClasspath"
    )
    analyzers(closureOf<org.owasp.dependencycheck.gradle.extension.AnalyzerExtension> {
        assemblyEnabled = false
        nodeAuditEnabled = false
    })
    format = org.owasp.dependencycheck.reporting.ReportGenerator.Format.ALL
    suppressionFile = "${project.projectDir}/dependency-check-suppressions.xml"
    outputDirectory = "${project.buildDir}/reports/owasp-dependency-check"
}

tasks.named<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask>("dependencyUpdates")
    .configure {
        outputDir = "${project.buildDir}/reports/dependency-updates"
    }
