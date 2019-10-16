package com.example.teste_android.domain.usecases

import com.example.teste_android.data.entities.SimulationInvestimentResult
import com.example.teste_android.presentation.common.UIStates

interface SimulateInvestimentUseCase {

    suspend fun launchSimulation(): UIStates

}