rootProject.name = "Template"

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

//app
include(
    ":app",
)

//Core
include(
    ":core:common",
    ":core:design",
    ":core:navigation",
    ":core:persistence",
)

//Features
include(
    ":features:splash",
    ":features:home"
)