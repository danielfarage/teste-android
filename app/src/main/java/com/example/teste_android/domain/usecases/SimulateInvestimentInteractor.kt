package com.example.teste_android.domain.usecases

import com.example.teste_android.data.entities.SimulationInvestimentResult
import com.example.teste_android.domain.repositories.SimulateInvestimentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SimulateInvestimentInteractor(
    private val simulateRepository: SimulateInvestimentRepository)
    : SimulateInvestimentUseCase {

    override suspend fun launchSimulation(): SimulationInvestimentResult {
        return withContext(Dispatchers.IO){
            simulateRepository.doSimulationInvestiment()
        }
    }

}