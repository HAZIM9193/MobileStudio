plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.exampletest.mobilestudiotest"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.exampletest.mobilestudiotest"
        minSdk = 24
        targetSdk = 37
        versionCode = 3
        versionName = "5.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = true
                packageScope = setOf("androidx.**", "kotlin.**", "kotlinx.**")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
        // The Anthropic SDK (AI Assistant) uses java.time, which Android only has from API 26.
        isCoreLibraryDesugaringEnabled = true
    }
    packaging {
        resources {
            // Jackson / OkHttp (used by the Anthropic SDK) ship duplicate metadata files.
            excludes += setOf("META-INF/versions/9/module-info.class", "META-INF/DEPENDENCIES", "META-INF/LICENSE*", "META-INF/NOTICE*", "META-INF/INDEX.LIST")
        }
    }
}

// Name the APK after the app version instead of the default "app-<buildType>.apk",
// e.g. versionName "1.1" -> "mobilestudio_ver1-1.apk". AGP 9 removed the old
// applicationVariants/outputFileName API, so this goes through the variant output impl.
androidComponents {
    onVariants { variant ->
        variant.outputs.forEach { output ->
            val version = output.versionName.orNull ?: "unknown"
            (output as? com.android.build.api.variant.impl.VariantOutputImpl)
                ?.outputFileName
                ?.set("mobilestudio_ver${version.replace('.', '-')}.apk")
        }
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    implementation(libs.androidx.recyclerview)
    implementation(libs.luaj.jse)
    implementation(variantOf(libs.zstd.jni) { artifactType("aar") })
    // AI Assistant: Claude through the official Anthropic SDK (the user's own API key).
    implementation(libs.anthropic.java)
    coreLibraryDesugaring(libs.desugar.jdk.libs)
    testImplementation(libs.junit)
    testImplementation(libs.zstd.jni)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}
