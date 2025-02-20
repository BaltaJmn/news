plugins {
    alias(libs.plugins.template.android.application)
}

android {
    packagingOptions {
        exclude("META-INF/*.*")
    }

    defaultConfig {
        manifestPlaceholders["redirectSchemeName"] = "template"
        manifestPlaceholders["redirectHostName"] = "auth"
    }
}

dependencies {
    implementation(projects.core.auth)
    implementation(projects.core.common)
    implementation(projects.core.data)
    implementation(projects.core.database)
    implementation(projects.core.design)
    implementation(projects.core.navigation)
    implementation(projects.core.network)
    implementation(projects.core.persistence)

    implementation(projects.features.splash)
    implementation(projects.features.preferences)
    implementation(projects.features.home)
    implementation(projects.features.article)
    implementation(projects.features.top)
    implementation(projects.features.settings)

    implementation(libs.androidx.workmanager)
    implementation(libs.gson)
}