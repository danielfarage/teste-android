package com.example.teste_android.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.io.Serializable

@Entity
data class SimulationInvestimentEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    var paramInvestedAmount: Double = 0.0,
    var paramYearlyInterestRate: Double = 0.0,
    var paramMaturityTotalDays: Int = 0,
    var paramMaturityBusinessDays: Int = 0,
    var paramMaturityDate: String = "",
    var paramRate: Double = 0.0,
    var paramIsTaxFree: Boolean = false,

    var grossAmount: Double = 0.0,
    var taxesAmount: Double = 0.0,
    var netAmount: Double = 0.0,
    var grossAmountProfit: Double = 0.0,
    var netAmountProfit: Double = 0.0,
    var annualGrossRateProfit: Double = 0.0,
    var monthlyGrossRateProfit: Double = 0.0,
    var dailyGrossRateProfit: Double = 0.0,
    var taxesRate: Double = 0.0,
    var rateProfit: Double = 0.0,
    var annualNetRateProfit: Double = 0.0
) : Serializable