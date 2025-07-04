plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
}

android {
  namespace = "com.ukrgasbank.ugbpaymentkotlinsdkexample"
  compileSdk = 33

  defaultConfig {
    applicationId = "com.ukrgasbank.ugbpaymentkotlinsdkexample"
    minSdk = 28
    targetSdk = 33
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    debug {
      isDebuggable = true
    }
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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

  implementation("com.ukrgasbank.ecom:ugbpaymentkotlinsdk:1.2.0")

  implementation("androidx.constraintlayout:constraintlayout:2.1.4")
  implementation("androidx.core:core-ktx:1.9.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
  implementation("androidx.activity:activity-compose:1.7.2")
  implementation(platform("androidx.compose:compose-bom:2023.03.00"))
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.compose.material3:material3")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
  androidTestImplementation("androidx.compose.ui:ui-test-junit4")
  debugImplementation("androidx.compose.ui:ui-tooling")
  debugImplementation("androidx.compose.ui:ui-test-manifest")



  implementation("androidx.appcompat:appcompat:1.6.1")
  implementation("io.ktor:ktor-client-core:2.1.0")
  implementation("io.ktor:ktor-client-cio:2.1.0")
  implementation("io.ktor:ktor-client-serialization:2.1.0")
  implementation("io.ktor:ktor-client-logging-jvm:2.1.0")
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2")
  implementation("com.google.code.gson:gson:2.8.8")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")

  implementation("com.google.android.gms:play-services-wallet:19.4.0")
  implementation("com.google.android.gms:play-services-base:18.5.0")
  implementation("com.google.android.gms:play-services-pay:16.5.0")

}