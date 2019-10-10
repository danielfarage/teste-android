package com.example.teste_android.presentation.common

import io.mockk.impl.annotations.MockK
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.robolectric.RobolectricTestRunner
import java.text.NumberFormat

@RunWith(JUnit4::class)
class StringExtensionsKtTest {

    @Test
    fun toMoney() {
        val valor = "25.00"
        assertEquals("R$25.00",valor.toMoney())
    }
}