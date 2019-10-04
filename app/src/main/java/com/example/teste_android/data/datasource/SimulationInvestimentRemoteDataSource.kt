package com.example.teste_android.data.datasource

import com.example.teste_android.data.api.SimulationInvestimentService
import com.example.teste_android.data.entities.SimulationInvestimentResult

class SimulationInvestimentRemoteDataSource(
    private val simulationInvestimentService: SimulationInvestimentService)
    : SimulationInvestimentDataSource {

    override suspend fun retrieveSimulation(): SimulationInvestimentResult {
        return simulationInvestimentService.retrieveSimulation()
    }

    override fun saveSimulation() = Unit
}