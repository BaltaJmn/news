package plugins

import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.LibraryExtension
import extensions.implementation
import extensions.implementationBom
import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidFirebasePlugin : Plugin<Project> {
    override fun apply(project: Project) = with(project) {
        val extension = extensions.getByType<LibraryExtension>()
        configureFirebase(extension)
    }
}

fun Project.configureFirebase(commonExtension: CommonExtension<*, *, *, *, *, *>) {
    pluginManager.apply {
        apply("com.google.gms.google-services")
    }

    dependencies {
        implementationBom(platform(libs.firebase.bom))
        implementation(libs.firebase.auth.ktx)
        implementation(libs.firebase.auth.ui)
        implementation(libs.firebase.realtime.database.ktx)
        implementation(libs.firebase.common)
        implementation(libs.firebase.google.services)
    }

}