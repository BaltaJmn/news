plugins {
    alias(libs.plugins.template.android.library)
}

android {
    namespace = Config.Core.Common

    packagingOptions {
        exclude("META-INF/*.*")
    }

}