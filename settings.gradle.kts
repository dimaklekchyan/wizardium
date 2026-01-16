rootProject.name = "Wizardium"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

include(":androidApp")
include(":common:core")
include(":common:data")
include(":common:domain")
include(":common:shared")
include(":common:res")
include(":common:design-system")