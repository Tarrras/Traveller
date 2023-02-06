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
include(":core:core-designsystem")
include(":core:core-ui")
include(":core:core-data")
include(":core:core-network")
include(":core:core-common")
include(":core:core-background")
include(":core:core-testing")
include(":flow:flow-authentication")
include(":feature-splash")
include(":flow:flow-home")
