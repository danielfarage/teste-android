package com.example.teste_android.presentation.entities

import java.io.Serializable

data class SimulatedInvestiment(
    val investmentParameter: Investment,
    val grossAmount: String,
    val taxesAmount: String,
    val netAmount: String,
    val grossAmountProfit: String,
    val netAmountProfit: String,
    val annualGrossRateProfit: String,
    val monthlyGrossRateProfit: String,
    val dailyGrossRateProfit: String,
    val taxesRate: String,
    val rateProfit: String,
    val annualNetRateProfit: String): Serializable

data class Investment(
    val investedAmount: String,
    val yearlyInterestRate: String,
    val maturityTotalDays: String,
    val maturityBusinessDays: String,
    val maturityDate: String,
    val rate: String,
    val isTaxFree: String
): Serializable