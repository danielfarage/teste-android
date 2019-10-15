package com.example.teste_android.data.datasource

import com.example.teste_android.data.api.SimulationInvestimentService
import com.example.teste_android.data.entities.SimulationInvestimentEntity
import com.example.teste_android.data.entities.SimulationInvestimentResult

class SimulationInvestimentRemoteDataSource(
    private val simulationInvestimentService: SimulationInvestimentService)
    : SimulationInvestimentDataSource {
    override fun saveSimulation(investimentEntity: SimulationInvestimentEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun retrieveSimulation(): SimulationInvestimentResult {
        return simulationInvestimentService.retrieveSimulation()
    }

}