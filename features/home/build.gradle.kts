plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.compose.library)
}

android {
    namespace = Config.Feature.Home

    packagingOptions {
        exclude("META-INF/*.*")
    }
}

dependencies {
    implementation(projects.core.data)
}