import com.example.df8c4968a760dfc86702c40ea88faf48.Configuration

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id(libs.plugins.android.application.get().pluginId)
  id(libs.plugins.kotlin.android.get().pluginId)
  id(libs.plugins.kotlin.kapt.get().pluginId)
  id(libs.plugins.kotlin.parcelize.get().pluginId)
  id(libs.plugins.hilt.plugin.get().pluginId)
}

android {
  compileSdk = Configuration.compileSdk
  namespace = "com.example.df8c4968a760dfc86702c40ea88faf48"
  defaultConfig {
    applicationId = "com.example.df8c4968a760dfc86702c40ea88faf48"
    minSdk = Configuration.minSdk
    targetSdk = Configuration.targetSdk
    versionCode = Configuration.versionCode
    versionName = Configuration.versionName
    vectorDrawables.useSupportLibrary = true
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  buildFeatures {
    dataBinding = true
  }

  hilt {
    enableAggregatingTask = true
  }

  kotlin {
    sourceSets.configureEach {
      kotlin.srcDir("$buildDir/generated/ksp/$name/kotlin/")
    }
  }

  testOptions {
    unitTests {
      isIncludeAndroidResources = true
      isReturnDefaultValues = true
    }
  }

  buildTypes {
    create("benchmark") {
      isDebuggable = true
      signingConfig = getByName("debug").signingConfig
      matchingFallbacks += listOf("release")
    }
  }

  lint {
    abortOnError = false
  }
}

dependencies {

  // androidx
  implementation(libs.material)
  implementation(libs.androidx.fragment)
  implementation(libs.androidx.lifecycle)
  implementation(libs.androidx.startup)

  // data binding
  implementation(libs.bindables)

  // di
  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)
  androidTestImplementation(libs.hilt.testing)
  kaptAndroidTest(libs.hilt.compiler)

  // coroutines
  implementation(libs.coroutines)

  // recyclerView
  implementation(libs.recyclerview)

  // unit test
  testImplementation(libs.junit)
  testImplementation(libs.turbine)
  testImplementation(libs.androidx.test.core)
  testImplementation(libs.mockito.kotlin)
  testImplementation(libs.mockito.inline)
  testImplementation(libs.coroutines.test)
  androidTestImplementation(libs.truth)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso)
  androidTestImplementation(libs.android.test.runner)
}
