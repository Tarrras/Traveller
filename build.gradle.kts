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
    tasks.withType(org.jetbrains.kotlin.gradle.dsl.KotlinCompile::class.java).configureEach {
        kotlinOptions {
            // Trigger this with:
            // ./gradlew assembleRelease -PenableMultiModuleComposeReports=true --rerun-tasks
            if (project.findProperty("enableMultiModuleComposeReports") == "true") {
                freeCompilerArgs += listOf(
                    "-P",
                    "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" + rootProject.buildDir.absolutePath + "/compose_metrics/"
                )
                freeCompilerArgs += listOf(
                    "-P",
                    "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" + rootProject.buildDir.absolutePath + "/compose_metrics/"
                )
            }
        }
    }
}

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
