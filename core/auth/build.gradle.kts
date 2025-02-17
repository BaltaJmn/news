plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.compose.library)
    alias(libs.plugins.template.android.firebase.library)
}

android {
    namespace = Config.Core.Auth

    packagingOptions {
        exclude("META-INF/*.*")
    }

    defaultConfig {
        buildConfigField("String", "PROJECT_ID", project.property("PROJECT_ID").toString())
        buildConfigField("String", "APP_ID", project.property("APP_ID").toString())
        buildConfigField("String", "API_KEY", project.property("API_KEY").toString())
    }
}