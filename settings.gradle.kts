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
include(":core-designsystem")
include(":core-ui")
include(":core-data")
include(":core-network")
