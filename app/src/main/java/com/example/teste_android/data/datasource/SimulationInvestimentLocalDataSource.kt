package com.example.teste_android.data.datasource

import com.example.teste_android.data.datasource.SimulationInvestimentDataSource
import com.example.teste_android.data.db.InvestimentDatabase
import com.example.teste_android.data.entities.SimulationInvestimentEntity
import com.example.teste_android.data.entities.SimulationInvestimentResult

class SimulationInvestimentLocalDataSource(
    private val investimentDatabase: InvestimentDatabase
) : SimulationInvestimentDataSource {

    override suspend fun retrieveSimulation(): SimulationInvestimentResult {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveSimulation(investimentEntity: SimulationInvestimentEntity) {
        investimentDatabase.investimentDao().cacheSimulationInvestiment(investimentEntity)
    }
}