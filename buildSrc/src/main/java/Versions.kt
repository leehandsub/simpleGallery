object Versions {
    const val LIFECYCLE_VERSION = "2.6.2"

    const val RETROFIT_VERSION = "2.9.0"
    const val OKHTTP_VERSION = "4.9.0"

    const val COMPOSE_VERSION = "1.8.1"

    const val COIL_VERSION = "2.4.0"

    // KTX
    const val CORE_VERSION = "1.7.0"
}

object Libraries {

    object AndroidX {
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_VERSION}"
        const val LIFECYCLE_RUNTIME_KTX =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_VERSION}"
        const val LIFECYCLE_VIEWMODEL_KTX =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.LIFECYCLE_VERSION}"
        const val COMPOSE = "androidx.activity:activity-compose:${Versions.COMPOSE_VERSION}"
    }


    object Test {
        const val JUNIT = "junit:junit:4.13.2"
        const val TEST_EXT = "androidx.test.ext:junit:1.1.5"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.5.1"
    }

    object RETROFIT {
        const val RETROFIT_CONVERTER =
            "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT_VERSION}"
        const val RETROFIT_CORE = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
    }

    object OKHTTP {
        const val OKHTTP_LOGGING =
            "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP_VERSION}"
        const val OKHTTP_CORE = "com.squareup.okhttp3:okhttp:${Versions.RETROFIT_VERSION}"
    }

    object COIL {
        const val COIL_COMPOSE = "io.coil-kt:coil-compose:${Versions.COIL_VERSION}"
    }
}