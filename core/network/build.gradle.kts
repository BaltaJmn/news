plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.compose.library)
}

android {
    namespace = Config.Core.Network

    packagingOptions {
        exclude("META-INF/*.*")
    }

    defaultConfig {
        buildConfigField("String", "API_SECRET", project.property("API_SECRET").toString())
    }
}

dependencies {
    implementation(libs.ktor.core)
    implementation(libs.ktor.logging)
    implementation(libs.ktor.negotiation)
    implementation(libs.ktor.okhttp)
    implementation(libs.ktor.serialization)
    implementation(libs.ktor.serializationJson)
    implementation(libs.loggingInterceptor)
}