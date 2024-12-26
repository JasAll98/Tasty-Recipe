import org.gradle.kotlin.dsl.android

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.serialization.plugin)
}

android {
    namespace = "com.jasallprojects.tastyrecipe"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.jasallprojects.tastyrecipe"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    // Implementing lifecycle viewmodel
    implementation(libs.androidx.lifecycle.viewmodel)

    // Implementing Coil
    implementation(libs.io.coil.kt)
    implementation(libs.io.coil.kt.network)

    // Implementing Icons
    implementation(libs.androidx.material.icons.extended)

    // Implementing Retrofit with OkHttp
    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.okhttp)

    //Implementing Kotlin Serialization with Converter
    implementation(libs.kotlinx.serialization)
    implementation(libs.kotlinx.serialization.converter)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}