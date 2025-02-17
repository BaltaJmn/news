plugins {
    alias(libs.plugins.template.android.library)
}

android {
    namespace = Config.Core.Persistence

    packagingOptions {
        exclude("META-INF/*.*")
    }
}

dependencies {
    implementation(libs.gson)
}