package com.example.teste_android.presentation.di

import android.content.Context
import com.example.teste_android.data.api.SimulationInvestimentService
import com.example.teste_android.data.db.InvestimentDatabase
import io.mockk.mockk
import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.dsl.module
import org.koin.test.check.checkModules

class KoinTest {

    val fakeModules = module(override = true) {
        single<SimulationInvestimentService> { mockk() }
        single<InvestimentDatabase> { mockk() }
    }

    @Test
    fun checkAllKoinModules() {
        koinApplication {
            modules(arrayListOf(fakeModules))
        }.checkModules()
    }

}