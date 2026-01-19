import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
}

kotlin {
    jvmToolchain(17)
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    )
    
    sourceSets {
        commonMain.dependencies {
            implementation(projects.common.core)
            implementation(projects.common.domain)

            implementation(libs.kotlin.serialization)
            implementation(libs.kotlin.datetime)

            implementation(libs.koin.core)

            implementation(libs.ktor.core)
            implementation(libs.ktor.negotiation)
            implementation(libs.ktor.serialization)
            implementation(libs.ktor.logging)

            implementation(libs.room.runtime)
            implementation(libs.sqlite.bundled)
        }

        androidMain.dependencies {
            implementation(libs.ktor.android)
        }
        iosMain.dependencies {
            implementation(libs.ktor.ios)
        }
    }
}

private val roomSchemaDirectory = "${rootProject.projectDir}/common/data/schemas"

android {

    namespace = "com.dimaklekchyan.wizardium.data"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    sourceSets {
        getByName("androidTest").assets.srcDir(roomSchemaDirectory)
    }
}

room {
    schemaDirectory(roomSchemaDirectory)
}

dependencies {
    add("kspAndroid", libs.room.compiler)
    add("kspIosSimulatorArm64", libs.room.compiler)
    add("kspIosArm64", libs.room.compiler)
}

