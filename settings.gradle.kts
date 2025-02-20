rootProject.name = "News"

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
    ":core:auth",
    ":core:common",
    ":core:data",
    ":core:database",
    ":core:design",
    ":core:navigation",
    ":core:network",
    ":core:persistence",
)

//Features
include(
    ":features:splash",
    ":features:preferences",
    ":features:home",
    ":features:article",
    ":features:top",
    ":features:settings"
)