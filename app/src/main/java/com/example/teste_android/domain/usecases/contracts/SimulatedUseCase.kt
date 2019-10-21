package com.example.teste_android.domain.usecases.contracts

import com.example.teste_android.presentation.entities.SimulatedInvestiment

interface SimulatedUseCase {

    suspend fun retrieveSimulatedInvestiment(): SimulatedInvestiment

}