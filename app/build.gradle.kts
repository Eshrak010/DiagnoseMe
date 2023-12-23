plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.diagnoseme"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.diagnoseme"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
/*
    packagingOptions {
        exclude ("com/itextpdf/io/font/cmap_info.txt")
        exclude ("com/itextpdf/io/font/cmap/*")
    }
    */
 */

}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("de.hdodenhof:circleimageview:3.1.0")
 //   implementation ("com.github.castorflex.smoothprogressbar:library:1.4.0")
    implementation("com.squareup.retrofit:retrofit:2.0.0-beta")
    implementation("com.squareup.retrofit:converter-gson:2.0.0-beta2")
  /*  implementation (fileTree("(dir: 'libs', include: ['*.jar'])"))
    implementation ("com.itextpdf:itext7-core:7.1.3")*/
    implementation("com.itextpdf:itext7-core:7.1.9")


}