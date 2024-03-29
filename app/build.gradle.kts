plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.catslist"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.catslist"
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

    buildFeatures {
            viewBinding = true
    }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    testImplementation("junit:junit:4.13.2")
    implementation("org.mockito:mockito-core:5.8.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    //DEPENDENCIAS RETROFIT
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation( "com.squareup.retrofit2:adapter-rxjava2:2.3.0")

    //RX
    implementation("com.jakewharton.rxbinding2:rxbinding:2.0.0")
    implementation ("io.reactivex.rxjava2:rxandroid:2.0.1")
    implementation ("io.reactivex.rxjava2:rxjava:2.1.1")

    //CARREGAMENTO DE IMAGEM
    implementation("io.coil-kt:coil:2.5.0")

    //KOIN
    implementation ("io.insert-koin:koin-android:3.4.0")

}