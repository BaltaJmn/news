import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.baltajmn.template.buildlogic"

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

gradlePlugin {
    plugins {
        register("templateAndroidApplication") {
            id = "template.android.application"
            implementationClass = "plugins.AndroidApplicationPlugin"
        }

        register("templateAndroidLibrary") {
            id = "template.android.library"
            implementationClass = "plugins.AndroidLibraryPlugin"
        }

        register("templateComposeLibrary") {
            id = "template.compose.library"
            implementationClass = "plugins.ComposePlugin"
        }

        register("templateRoomLibrary") {
            id = "template.room.library"
            implementationClass = "plugins.AndroidRoomPlugin"
        }

        register("templateFirebaseLibrary") {
            id = "template.firebase.library"
            implementationClass = "plugins.AndroidFirebasePlugin"
        }
    }
}

repositories {
    google()
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
    gradlePluginPortal()
}

dependencies {
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.plugin.android)
    implementation(libs.plugin.gradle)
    implementation(libs.plugin.ktlint)
    implementation(libs.plugin.kotlin.serialization)
    implementation(libs.plugin.kotlin.ksp)
    implementation(libs.firebase.google.services)
}