package com.example.teste_android.presentation.common

import io.mockk.impl.annotations.MockK
import org.junit.Test

import org.junit.Assert.*
import java.text.NumberFormat

class StringExtensionsKtTest {

    @Test
    fun toMoney() {
        val valor = "25.00"
        assertEquals("R$25.00",valor.toMoney())
    }
}