plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id ("kotlin-kapt")
}

android {
    namespace = "com.example.simplegallery"
    compileSdk = AppConfig.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = "com.example.simplegallery"
        minSdk = AppConfig.MIN_SDK_VERSION
        targetSdk = AppConfig.TARGET_SDK_VERSION
        versionCode = AppConfig.APP_VERSION_CODE
        versionName = AppConfig.APP_VERSION_NAME

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
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

dependencies {

    implementation(Libraries.AndroidX.CORE_KTX)
    implementation(Libraries.AndroidX.LIFECYCLE_RUNTIME_KTX)
    implementation(Libraries.AndroidX.COMPOSE)
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation(Libraries.Test.JUNIT)
    androidTestImplementation(Libraries.Test.TEST_EXT)
    androidTestImplementation(Libraries.Test.ESPRESSO_CORE)

    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //retrofit & okhttp
    implementation(Libraries.RETROFIT.RETROFIT_CORE)
    implementation(Libraries.RETROFIT.RETROFIT_CONVERTER)
    implementation(Libraries.OKHTTP.OKHTTP_CORE)
    implementation(Libraries.OKHTTP.OKHTTP_LOGGING)

    //coil
    implementation(Libraries.COIL.COIL_COMPOSE)

    //viewModel
    implementation(Libraries.AndroidX.LIFECYCLE_VIEWMODEL_KTX)
    implementation(Libraries.AndroidX.VIEWMODEL)

    //navigation
    implementation(Libraries.AndroidX.NAVIGATION)

    //dager
    implementation(Libraries.DAGGER.DAGGER)
    kapt(Libraries.DAGGER.DAGGER_COMPILER)
}