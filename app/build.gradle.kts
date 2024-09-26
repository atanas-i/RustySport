plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.serialization.gradle.plugin)
    alias(libs.plugins.ksp.gradle.plugin)
    alias(libs.plugins.hilt.android.gradle.plugin)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "dev.rustybite.rustysports"
    compileSdk = 34

    defaultConfig {
        applicationId = "dev.rustybite.rustysports"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    //Core Ktx
    implementation(libs.androidx.core.ktx)

    //Lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx)

    //Compose
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)

    //Material3
    implementation(libs.androidx.material3)

    //Hilt
    implementation(libs.hilt.dependency.injection)
    ksp(libs.hilt.android.compiler)

    //Navigation
    implementation(libs.navigation)
    implementation(libs.hilt.navigation.compose)

    //Datastore
    implementation(libs.datastore.preferences)
    implementation(libs.datastore.preferences.core)

    //Coil
    implementation(libs.coil.compose)

    //Serialization
    implementation(libs.kotlin.serialization.json)

    //Splash Screen
    implementation(libs.splash.screen)

    //Retro
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)

    //Compose Test
    androidTestImplementation(platform(libs.androidx.compose.bom))
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}