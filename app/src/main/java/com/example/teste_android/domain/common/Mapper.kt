package com.example.teste_android.domain.common

import com.example.teste_android.data.entities.SimulationInvestimentEntity
import com.example.teste_android.presentation.entities.Investment
import com.example.teste_android.presentation.entities.SimulatedInvestiment

object Mapper {

    fun toPresenter(simulationEntity: SimulationInvestimentEntity): SimulatedInvestiment {
        val investimentParams = Investment().apply {
            investedAmount = simulationEntity.paramInvestedAmount.toString()
            yearlyInterestRate = simulationEntity.paramYearlyInterestRate.toString()
            maturityTotalDays = simulationEntity.paramMaturityTotalDays.toString()
            maturityBusinessDays = simulationEntity.paramMaturityBusinessDays.toString()
            maturityDate = simulationEntity.paramMaturityDate
            rate = simulationEntity.paramRate.toString()
            isTaxFree = simulationEntity.paramIsTaxFree.toString()
        }
        return SimulatedInvestiment().apply {
            investmentParameter = investimentParams
            grossAmount = simulationEntity.grossAmount.toString()
            taxesAmount = simulationEntity.taxesAmount.toString()
            netAmount = simulationEntity.netAmount.toString()
            grossAmountProfit = simulationEntity.grossAmountProfit.toString()
            netAmountProfit = simulationEntity.netAmountProfit.toString()
            annualGrossRateProfit = simulationEntity.annualGrossRateProfit.toString()
            monthlyGrossRateProfit = simulationEntity.monthlyGrossRateProfit.toString()
            dailyGrossRateProfit = simulationEntity.dailyGrossRateProfit.toString()
            taxesRate = simulationEntity.taxesRate.toString()
            rateProfit = simulationEntity.rateProfit.toString()
            annualNetRateProfit = simulationEntity.annualNetRateProfit.toString()
        }
    }

}