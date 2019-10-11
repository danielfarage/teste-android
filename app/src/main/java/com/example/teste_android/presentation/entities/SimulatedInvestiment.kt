package com.example.teste_android.presentation.entities

import java.io.Serializable

data class SimulatedInvestiment(
    var investmentParameter: Investment = Investment(),
    var grossAmount: String = "",
    var taxesAmount: String = "",
    var netAmount: String = "",
    var grossAmountProfit: String = "",
    var netAmountProfit: String = "",
    var annualGrossRateProfit: String = "",
    var monthlyGrossRateProfit: String = "",
    var dailyGrossRateProfit: String = "",
    var taxesRate: String = "",
    var rateProfit: String = "",
    var annualNetRateProfit: String = ""): Serializable

data class Investment(
    var investedAmount: String = "",
    var yearlyInterestRate: String = "",
    var maturityTotalDays: String = "",
    var maturityBusinessDays: String = "",
    var maturityDate: String = "",
    var rate: String = "",
    var isTaxFree: String = ""
): Serializable