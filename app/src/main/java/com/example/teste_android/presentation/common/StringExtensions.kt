package com.example.teste_android.presentation.common

import android.annotation.TargetApi
import android.icu.text.DateFormat
import android.icu.text.DateFormatSymbols
import android.icu.text.NumberFormat
import android.icu.text.SimpleDateFormat
import android.icu.util.TimeZone
import android.os.Build
import androidx.annotation.RequiresApi
import java.lang.Exception
import java.math.RoundingMode
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@TargetApi(Build.VERSION_CODES.N)
fun String.toMoneyMask() : String {
    val currencyInstance = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
    val newValue = this
        .replace(Regex("[R$,.]"), "")
        .trim()
        .toDouble()

    return currencyInstance.format((newValue/100))

}

@TargetApi(Build.VERSION_CODES.N)
fun String.toMoney() : String {
    val currencyInstance = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
    val newValue = this.toDouble()

    return currencyInstance.format((newValue))

}

@TargetApi(Build.VERSION_CODES.N)
fun String.toPercent() : String {
    val newValue = this.toDouble()
    val percentInstance = NumberFormat.getPercentInstance().apply {
        isParseIntegerOnly = true
    }
    return percentInstance.format(newValue*10).toString()
}

@TargetApi(Build.VERSION_CODES.O)
fun String.toDate() : String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm").apply {
        timeZone = TimeZone.getTimeZone("UTC")
    }
    val newDate = SimpleDateFormat("dd/MM/yyy").format(dateFormat.parse(this))
    return newDate.toString()
}