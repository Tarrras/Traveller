pluginManagement {
    includeBuild("build-core")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

enableFeaturePreview("VERSION_CATALOGS")
rootProject.name = "Traveller"
include(":app")