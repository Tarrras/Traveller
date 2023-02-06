plugins {
    id("traveller.android.application")
    id("traveller.android.application.compose")
    id("kotlin-parcelize")
    kotlin("kapt")
    id("org.owasp.dependencycheck")
    id("kotlinx-serialization")
    id("com.google.devtools.ksp")
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

    testOptions {
        unitTests {
            isReturnDefaultValues = true
            isIncludeAndroidResources = true
            all {
                it.testLogging {
                    events("passed", "skipped", "failed", "standardOut", "standardError")
                }
            }
        }
    }
}

dependencies {
    implementation(project(":flow:flow-authentication"))
    implementation(project(":flow:flow-home"))
    implementation(project(":feature-splash"))
    implementation(project(":core:core-background"))
    implementation(project(":core:core-ui"))
    implementation(project(":core:core-testing"))

    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.androidx.appcompat)
    implementation(libs.com.google.android.material)

    implementation(libs.org.jetbrains.kotlin.stdlib.jdk8)
    implementation(libs.org.jetbrains.kotlin.reflect)

    implementation(libs.com.google.hilt)
    implementation(libs.androidx.hilt.navigation.compose)
    kapt(libs.com.google.hilt.compiler)
    kapt(libs.androidx.hilt.compiler)

    /*testImplementation(libs.org.jetbrains.kotlin.test.junit)

    implementation(libs.org.jetbrains.kotlinx.coroutines.core)
    implementation(libs.org.jetbrains.kotlinx.coroutines.android)
    implementation(libs.org.jetbrains.kotlinx.coroutines.play.services)
    testImplementation(libs.org.jetbrains.kotlinx.coroutines.test)

    implementation(libs.androidx.annotation)

    implementation(libs.androidx.collection.ktx)

    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.common)
    implementation(libs.androidx.lifecycle.process)

    implementation(libs.androidx.constraintlayout.compose)

    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.paging)
    testImplementation(libs.androidx.room.testing)

    implementation(libs.androidx.datastore.preferences)*/
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
