plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.googleDevtoolsKsp)
    alias(libs.plugins.googleDaggerHiltAndroid)

}

android {
    namespace = "com.usermanage.usercrud"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.usermanage.usercrud"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    viewBinding {
        enable=true
    }
    dataBinding {
        enable=true
    }
}



dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    //ssp-sdp
    implementation(libs.ssp.android)
    implementation(libs.sdp.android)

    //secured shared preference
    implementation(libs.androidx.security.crypto)

    //test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //room
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.compiler)

    //coroutines
    implementation(libs.kotlinx.coroutines.android)

    //daggerHilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)


}