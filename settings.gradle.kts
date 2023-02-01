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
include(":core-common")
include(":core-background")
include(":flow-authentication")
include(":feature-splash")
include(":flow-home")
include(":core-testing")
