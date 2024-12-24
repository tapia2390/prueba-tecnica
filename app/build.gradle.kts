plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.appandroid"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.appandroid"
        minSdk = 24
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


    buildFeatures {
        viewBinding =(true)
        dataBinding =(true)
        buildConfig =(true)
    }




}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)




    implementation (libs.retrofit)
    implementation (libs.retrofit2.converter.gson)
    implementation (libs.logging.interceptor)


    implementation (libs.hilt.android)
    annotationProcessor (libs.google.dagger.compiler )

    implementation (libs.gson)

    implementation (libs.library)


}