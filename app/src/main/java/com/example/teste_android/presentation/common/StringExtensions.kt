package com.example.teste_android.presentation.common

import android.annotation.TargetApi
import android.icu.text.NumberFormat
import android.os.Build
import java.lang.Exception
import java.util.*

@TargetApi(Build.VERSION_CODES.N)
fun String.toMoney() : String {
    val currencyInstance = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
    val newValue = this
        .replace(Regex("[R$,.]"), "")
        .trim()
        .toDouble()

    return currencyInstance.format((newValue/100))

}