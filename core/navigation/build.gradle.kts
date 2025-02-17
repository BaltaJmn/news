plugins {
    alias(libs.plugins.template.android.library)
}

android {
    namespace = Config.Core.Navigation

    packagingOptions {
        exclude("META-INF/*.*")
    }

}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.navigation)
}