plugins {
    alias(libs.plugins.android.application)

}



android {
    namespace = "com.example.store"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.store"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {

        dataBinding=true     // برای غیرفعال کردن DataBinding

    }
}



dependencies {
    implementation ("com.google.android.material:material:1.12.0") // برای استفاده از NavigationView


    implementation ("androidx.appcompat:appcompat:1.7.0")
    implementation ("com.google.android.material:material:1.12.0")
    implementation(libs.activity)
    implementation(libs.constraintlayout)





    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.2.1")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.6.1")


    // اصلی‌ها
    implementation ("androidx.navigation:navigation-fragment:2.9.0")
    implementation ("androidx.navigation:navigation-ui:2.9.0")

//smoothbottombar
    implementation("com.github.ibrahimsn98:SmoothBottomBar:1.7.9")

    //hilt
    implementation("com.google.dagger:hilt-android:2.56.2")
    annotationProcessor ("com.google.dagger:hilt-android-compiler:2.56.2")

    //glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")

    //ronded imageview

    implementation ("com.makeramen:roundedimageview:2.3.0")


    implementation ("androidx.viewpager2:viewpager2:1.1.0")



}
