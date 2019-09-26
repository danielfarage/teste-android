object Libraries {

    object Versions {
        const val kotlinVersion = "1.3.50"
        const val buildToolsVersion = "3.5.0"
        const val jetpack = "1.0.0"
        const val constraintLayout = "1.1.3"
        const val ktx = "1.1.0"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val testRunner = "1.2.0"
        const val espresso = "3.2.0"
        const val mockk = "1.9.3"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

}
