package com.example.teste_android.domain.usecases

import com.example.teste_android.data.common.Mapper
import com.example.teste_android.domain.repositories.SimulateInvestimentRepository
import com.example.teste_android.domain.usecases.contracts.SimulateInvestimentUseCase
import com.example.teste_android.presentation.common.UIStates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SimulateInvestimentUseCaseImpl(
    private val simulateRepository: SimulateInvestimentRepository)
    : SimulateInvestimentUseCase {

    override suspend fun launchSimulation(): UIStates<Nothing> {
        try {
            withContext(Dispatchers.IO){
                val simulatedInvestiment = simulateRepository.doSimulationInvestiment()
                simulateRepository.saveSimulationToDB(Mapper.toDatabaseEntity(simulatedInvestiment))
            }
        }catch (e: Exception) {
            return UIStates.Failure(e)
        }
        return UIStates.SuccessNoData()
    }

}