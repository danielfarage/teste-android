package com.example.teste_android.domain.usecases

import com.example.teste_android.data.common.Mapper
import com.example.teste_android.data.entities.SimulationInvestimentResult
import com.example.teste_android.domain.repositories.SimulateInvestimentRepository
import com.example.teste_android.presentation.common.Failure
import com.example.teste_android.presentation.common.SuccessNoData
import com.example.teste_android.presentation.common.UIStates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.KoinApplication

class SimulateInvestimentInteractor(
    private val simulateRepository: SimulateInvestimentRepository)
    : SimulateInvestimentUseCase {

    override suspend fun launchSimulation(): UIStates {
        try {
            withContext(Dispatchers.IO){
                val simulatedInvestiment = simulateRepository.doSimulationInvestiment()
                simulateRepository.saveSimulationToDB(Mapper.toDatabaseEntity(simulatedInvestiment))
            }
        }catch (e: Exception) {
            return Failure(e)
        }
        return SuccessNoData
    }

}