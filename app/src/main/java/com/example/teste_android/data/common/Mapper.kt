package com.example.teste_android.data.common

import com.example.teste_android.data.entities.SimulationInvestimentEntity
import com.example.teste_android.presentation.entities.Investment
import com.example.teste_android.presentation.entities.SimulatedInvestiment

object Mapper {

    fun toDatabaseEntity(simulatedInvestiment: SimulatedInvestiment): SimulationInvestimentEntity {
        return SimulationInvestimentEntity().apply {
            paramInvestedAmount = simulatedInvestiment.investmentParameter.investedAmount.toDouble()
            paramYearlyInterestRate =
                simulatedInvestiment.investmentParameter.investedAmount.toDouble()
            paramMaturityTotalDays = simulatedInvestiment.investmentParameter.investedAmount.toInt()
            paramMaturityBusinessDays =
                simulatedInvestiment.investmentParameter.investedAmount.toInt()
            paramMaturityDate = simulatedInvestiment.investmentParameter.investedAmount
            paramRate = simulatedInvestiment.investmentParameter.investedAmount.toDouble()
            paramIsTaxFree = simulatedInvestiment.investmentParameter.investedAmount.toBoolean()

            grossAmount = simulatedInvestiment.grossAmount.toDouble()
            taxesAmount = simulatedInvestiment.taxesAmount.toDouble()
            netAmount = simulatedInvestiment.netAmount.toDouble()
            grossAmountProfit = simulatedInvestiment.grossAmountProfit.toDouble()
            netAmountProfit = simulatedInvestiment.netAmountProfit.toDouble()
            annualGrossRateProfit = simulatedInvestiment.annualGrossRateProfit.toDouble()
            monthlyGrossRateProfit = simulatedInvestiment.monthlyGrossRateProfit.toDouble()
            dailyGrossRateProfit = simulatedInvestiment.dailyGrossRateProfit.toDouble()
            taxesRate = simulatedInvestiment.taxesRate.toDouble()
            rateProfit = simulatedInvestiment.rateProfit.toDouble()
            annualNetRateProfit = simulatedInvestiment.annualNetRateProfit.toDouble()

        }
    }

    fun fromDatabaseEntity(simulationEntity: SimulationInvestimentEntity): SimulatedInvestiment {
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