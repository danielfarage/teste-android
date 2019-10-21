package com.example.teste_android.domain.usecases

import com.example.teste_android.domain.common.Mapper
import com.example.teste_android.domain.repositories.SimulateInvestimentRepository
import com.example.teste_android.domain.usecases.contracts.SimulatedUseCase
import com.example.teste_android.presentation.entities.SimulatedInvestiment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SimulatedUseCaseImpl(
    val simulateRepository: SimulateInvestimentRepository
): SimulatedUseCase {

    override suspend fun retrieveSimulatedInvestiment(): SimulatedInvestiment {
        return withContext(Dispatchers.IO){
            Mapper.toPresenter(simulateRepository.retrieveSimulationFromDB())
        }
    }

}