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
        const val room = "2.2.0"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinVersion}"

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val design = "com.google.android.material:material:${Versions.jetpack}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"
    const val lifeCycle = "androidx.lifecycle:lifecycle-extensions:${Versions.viewModel}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.jetpack}"
    const val koin = "org.koin:koin-android-viewmodel:${Versions.koin}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val junit5 = "5.2.0"
        const val testRunner = "1.2.0"
        const val espresso = "3.2.0"
        const val mockk = "1.9.3"
        const val coroutines = "1.3.2"
        const val coreTesting = "2.1.0"
        const val testCore = "1.2.1-alpha02"
        const val roboelectric = "4.3"
        const val room = "2.2.0"
        const val koin = "2.0.1"
        const val extJUnitVersion = "1.1.2-alpha02"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val junit5_jupiter = "org.junit.jupiter:junit-jupiter-api:${Versions.junit5}"
    const val junit5_jupiter_runtime = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit5}"
    const val junit5_jupiter_params = "org.junit.jupiter:junit-jupiter-params:${Versions.junit5}"
    const val junit5_vintage = "org.junit.vintage:junit-vintage-engine:${Versions.junit5}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val roboelectric = "org.robolectric:robolectric:${Versions.roboelectric}"
    const val roomTester = "androidx.room:room-testing:${Versions.room}"
    const val koinTester = "org.koin:koin-test:${Versions.koin}"

    //Instrumentados
    const val testCore = "androidx.test:core:${Versions.testCore}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJUnitVersion}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val espressoAccessibility = "androidx.test.espresso:espresso-accessibility:${Versions.espresso}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"

}
