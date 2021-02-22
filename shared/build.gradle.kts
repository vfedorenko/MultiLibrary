import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
//    id("kotlin-android-extensions")
    kotlin("plugin.serialization")
    id("com.squareup.sqldelight")
}
group = "by.vfedorenko.multibooking"
version = "1.0-SNAPSHOT"

android {
    compileSdkVersion(AndroidSdk.compile)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    // Workaround for AGP 7.0 https://issuetracker.google.com/issues/175496966
    configurations {
        create("androidTestApi")
        create("androidTestDebugApi")
        create("androidTestReleaseApi")
        create("testApi")
        create("testDebugApi")
        create("testReleaseApi")
    }
}

kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }

    sourceSets["commonMain"].dependencies {
        implementation(Coroutines.core)
        implementation(Serialization.core)
        implementation(Ktor.clientCore)
        implementation(Ktor.clientSerialization)
        implementation(SqlDelight.runtime)
        implementation(Koin.core)
        implementation(Deps.settings)
    }

    sourceSets["commonTest"].dependencies {
        implementation(kotlin("test-common"))
        implementation(kotlin("test-annotations-common"))
    }

    sourceSets["androidMain"].dependencies {
        implementation(Ktor.clientAndroid)
        implementation(SqlDelight.androidDriver)
    }

    sourceSets["androidTest"].dependencies {
        implementation(kotlin("test-junit"))
        implementation("junit:junit:4.12")
    }

    sourceSets["iosMain"].dependencies {
        implementation(Ktor.clientIos)
        implementation(SqlDelight.nativeDriver)
    }
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework =
        kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}
tasks.getByName("build").dependsOn(packForXcode)
