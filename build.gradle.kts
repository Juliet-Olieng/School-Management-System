// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id ("com.android.library") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
}
buildscript {
    dependencies {
        // Ensure this is present for Kotlin annotation processing (kapt)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0") // Match your Kotlin version
    }
}