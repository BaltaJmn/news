plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.room.library)
}

android {
    namespace = Config.Core.Database

    packagingOptions {
        exclude("META-INF/*.*")
    }

}
