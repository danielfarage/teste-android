package com.example.teste_android.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class SimulationInvestimentEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val investmentParameter: InvestmentParameter,
    val grossAmount: Double,
    val taxesAmount: Double,
    val netAmount: Double,
    val grossAmountProfit: Double,
    val netAmountProfit: Double,
    val annualGrossRateProfit: Double,
    val monthlyGrossRateProfit: Double,
    val dailyGrossRateProfit: Double,
    val taxesRate: Double,
    val rateProfit: Double,
    val annualNetRateProfit: Double
) : Serializable