plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.compose.library)
}

android {
    namespace = Config.Core.Design

    packagingOptions {
        exclude("META-INF/*.*")
    }

}