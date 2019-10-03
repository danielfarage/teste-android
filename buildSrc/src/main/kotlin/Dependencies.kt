object Libraries {

    object Versions {
        const val kotlinVersion = "1.3.50"
        const val buildToolsVersion = "3.5.0"
        const val jetpack = "1.0.0"
        const val constraintLayout = "1.1.3"
        const val ktx = "1.1.0"
        const val coroutines = "1.3.0"
        const val viewModel = "2.1.0"
        const val koin = "2.0.1"
        const val retrofit = "2.6.1"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"
    const val lifeCycle = "androidx.lifecycle:lifecycle-extensions:${Versions.viewModel}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.jetpack}"
    const val koin = "org.koin:koin-android-viewmodel:${Versions.koin}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val testRunner = "1.2.0"
        const val espresso = "3.2.0"
        const val mockk = "1.9.3"
        const val coroutines = "1.3.0"
        const val coreTesting = "2.1.0"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"

}
