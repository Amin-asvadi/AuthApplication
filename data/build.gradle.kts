plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.data"
    compileSdk = 35

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(project(":base-android"))
    implementation(project(":common-ui-resources"))
    libs.apply {
        implementation(kotlinx.serialization.converter)
        implementation(kotlinx.serialization.json)
        implementation(android.data.store)
        implementation(work.runtime)
        implementation(work.manager)
        implementation(dagger.hilt.android)
        implementation(dagger.hilt.navigation)
        ksp(dagger.hilt.compiler)
        implementation(retrofit)
        implementation(libs.androidx.room.common)
        implementation(adapter.rxjava2)
        implementation(logging.interceptor)
    }
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}