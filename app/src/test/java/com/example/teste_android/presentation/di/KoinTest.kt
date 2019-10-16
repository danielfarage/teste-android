package com.example.teste_android.presentation.di

import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.dsl.module
import org.koin.test.check.checkModules

class KoinTest {

    val fakeModules = module(override = true) {
        single<> { mock() }
        single<ItauStorageManager> { mock() }
        single<OfferStorageManager> { mock() }
    }

    @Test
    fun checkAllKoinModules() {
        koinApplication {
            modules(appModules)
        }.checkModules()
    }

}