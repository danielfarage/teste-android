package com.example.teste_android.data.common

import com.example.teste_android.data.entities.InvestmentParameter
import com.example.teste_android.data.entities.SimulationInvestimentEntity
import com.example.teste_android.data.entities.SimulationInvestimentResult
import com.example.teste_android.presentation.entities.SimulatedInvestiment

object Mapper {

    fun toDatabaseEntity(simulatedInvestiment: SimulationInvestimentResult): SimulationInvestimentEntity {
        return SimulationInvestimentEntity().apply {
            paramInvestedAmount = simulatedInvestiment.investmentParameter.investedAmount
            paramYearlyInterestRate = simulatedInvestiment.investmentParameter.yearlyInterestRate
            paramMaturityTotalDays = simulatedInvestiment.investmentParameter.maturityTotalDays
            paramMaturityBusinessDays = simulatedInvestiment.investmentParameter.maturityBusinessDays
            paramMaturityDate = simulatedInvestiment.investmentParameter.maturityDate
            paramRate = simulatedInvestiment.investmentParameter.rate
            paramIsTaxFree = simulatedInvestiment.investmentParameter.isTaxFree

            grossAmount = simulatedInvestiment.grossAmount
            taxesAmount = simulatedInvestiment.taxesAmount
            netAmount = simulatedInvestiment.netAmount
            grossAmountProfit = simulatedInvestiment.grossAmountProfit
            netAmountProfit = simulatedInvestiment.netAmountProfit
            annualGrossRateProfit = simulatedInvestiment.annualGrossRateProfit
            monthlyGrossRateProfit = simulatedInvestiment.monthlyGrossRateProfit
            dailyGrossRateProfit = simulatedInvestiment.dailyGrossRateProfit
            taxesRate = simulatedInvestiment.taxesRate
            rateProfit = simulatedInvestiment.rateProfit
            annualNetRateProfit = simulatedInvestiment.annualNetRateProfit

        }
    }

    fun toSimulationInvestimentResult(simulationEntity: SimulationInvestimentEntity): SimulationInvestimentResult {
        val investimentParams = InvestmentParameter().apply {
            investedAmount = simulationEntity.paramInvestedAmount
            yearlyInterestRate = simulationEntity.paramYearlyInterestRate
            maturityTotalDays = simulationEntity.paramMaturityTotalDays
            maturityBusinessDays = simulationEntity.paramMaturityBusinessDays
            maturityDate = simulationEntity.paramMaturityDate
            rate = simulationEntity.paramRate
            isTaxFree = simulationEntity.paramIsTaxFree
        }
        return SimulationInvestimentResult().apply {
            investmentParameter = investimentParams
            grossAmount = simulationEntity.grossAmount
            taxesAmount = simulationEntity.taxesAmount
            netAmount = simulationEntity.netAmount
            grossAmountProfit = simulationEntity.grossAmountProfit
            netAmountProfit = simulationEntity.netAmountProfit
            annualGrossRateProfit = simulationEntity.annualGrossRateProfit
            monthlyGrossRateProfit = simulationEntity.monthlyGrossRateProfit
            dailyGrossRateProfit = simulationEntity.dailyGrossRateProfit
            taxesRate = simulationEntity.taxesRate
            rateProfit = simulationEntity.rateProfit
            annualNetRateProfit = simulationEntity.annualNetRateProfit
        }
    }

}