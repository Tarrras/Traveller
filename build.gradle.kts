buildscript {

    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }

    dependencies {
        classpath(libs.com.android.tools.build.gradle)
        classpath(libs.org.jetbrains.kotlin.gradle)
        classpath(libs.org.jetbrains.kotlin.serialization)
        classpath(libs.org.owasp.dependency.check.gradle)
        classpath(libs.com.google.devtools.ksp.gradle)
        classpath(libs.com.google.gms.google.services)
        classpath(libs.com.github.ben.manes.gradle.versions.gradle)
        classpath(libs.com.google.hilt.gradle)
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.

apply(plugin = "com.github.ben-manes.versions")

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}

tasks.named<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask>("dependencyUpdates")
    .configure {
        outputDir = "${project.buildDir}/reports/dependency-updates"
    }
