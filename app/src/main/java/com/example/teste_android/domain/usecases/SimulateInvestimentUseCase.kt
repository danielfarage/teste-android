package com.example.teste_android.domain.usecases

import com.example.teste_android.data.entities.SimulationInvestimentResult

interface SimulateInvestimentUseCase {

    suspend fun launchSimulation(): SimulationInvestimentResult

}