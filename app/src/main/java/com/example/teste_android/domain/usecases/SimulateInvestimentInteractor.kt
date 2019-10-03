package com.example.teste_android.domain.usecases

import com.example.teste_android.domain.repositories.SimulateInvestimentRepository
import org.koin.core.KoinApplication

class SimulateInvestimentInteractor(val simulateRepository: SimulateInvestimentRepository)
    : SimulateInvestimentUseCase {

    override fun launchSimulation() {
        KoinApplication.logger.info("ABACAXI")
    }

}