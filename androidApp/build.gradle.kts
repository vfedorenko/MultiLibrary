plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("android")
//    id("kotlin-android-extensions")
}

group = "by.vfedorenko.multibooking"
version = "1.0-SNAPSHOT"

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "by.vfedorenko.multibooking.androidApp"
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
//    buildFeatures {
//        compose = true
//    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = Versions.compose
//        kotlinCompilerVersion = Versions.kotlin
//    }
}

dependencies {
    implementation(project(":shared"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")

    implementation(Koin.android)
    implementation(Koin.androidViewModel)

    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
//    implementation("androidx.legacy:legacy-support-v4:1.0.0")
//    implementation("androidx.fragment:fragment-ktx:1.2.5")

    implementation(Compose.ui)
    implementation(Compose.uiGraphics)
    implementation(Compose.uiTooling)
    implementation(Compose.foundationLayout)
    implementation(Compose.material)
    implementation(Compose.runtimeLiveData)
    implementation(Compose.navigation)
}
repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}