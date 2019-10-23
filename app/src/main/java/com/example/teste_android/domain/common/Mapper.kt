package com.example.teste_android.domain.common

import com.example.teste_android.data.entities.SimulationInvestimentEntity
import com.example.teste_android.presentation.common.toDate
import com.example.teste_android.presentation.common.toMoney
import com.example.teste_android.presentation.common.toPercent
import com.example.teste_android.presentation.entities.Investment
import com.example.teste_android.presentation.entities.SimulatedInvestiment

object Mapper {

    fun toPresenter(simulationEntity: SimulationInvestimentEntity): SimulatedInvestiment {
        val investimentParams = Investment().apply {
            investedAmount = simulationEntity.paramInvestedAmount.toString().toMoney()
            yearlyInterestRate = simulationEntity.paramYearlyInterestRate.toString().toMoney()
            maturityTotalDays = simulationEntity.paramMaturityTotalDays.toString()
            maturityBusinessDays = simulationEntity.paramMaturityBusinessDays.toString()
            maturityDate = simulationEntity.paramMaturityDate.toDate()
            rate = simulationEntity.paramRate.toString().toPercent()
            isTaxFree = simulationEntity.paramIsTaxFree.toString()
        }
        return SimulatedInvestiment().apply {
            investmentParameter = investimentParams
            grossAmount = simulationEntity.grossAmount.toString().toMoney()
            taxesAmount = simulationEntity.taxesAmount.toString().toMoney()
            netAmount = simulationEntity.netAmount.toString().toMoney()
            grossAmountProfit = simulationEntity.grossAmountProfit.toString().toMoney()
            netAmountProfit = simulationEntity.netAmountProfit.toString().toMoney()
            annualGrossRateProfit = simulationEntity.annualGrossRateProfit.toString().toMoney()
            monthlyGrossRateProfit = simulationEntity.monthlyGrossRateProfit.toString().toMoney()
            dailyGrossRateProfit = simulationEntity.dailyGrossRateProfit.toString()
            taxesRate = simulationEntity.taxesRate.toString().toPercent()
            rateProfit = simulationEntity.rateProfit.toString().toPercent()
            annualNetRateProfit = simulationEntity.annualNetRateProfit.toString().toPercent()
        }
    }

}