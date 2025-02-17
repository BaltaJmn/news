plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.compose.library)
}

android {
    namespace = Config.Core.Data

    packagingOptions {
        exclude("META-INF/*.*")
    }

}

dependencies {
    implementation(projects.core.network)
    implementation(projects.core.database)
    implementation(projects.core.design)
    implementation(libs.androidx.workmanager)
}