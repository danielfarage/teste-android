package com.example.teste_android.data.datasource

import com.example.teste_android.data.dao.SimulationInvestimentDao
import com.example.teste_android.data.db.InvestimentDatabase
import com.example.teste_android.data.entities.SimulationInvestimentEntity
import com.example.teste_android.data.entities.SimulationInvestimentResult

class SimulationInvestimentLocalDataSource(
    private val investimentDatabase: InvestimentDatabase) {

    private val investimentDao: SimulationInvestimentDao = investimentDatabase.investimentDao()

    fun retrieveSimulation(): SimulationInvestimentEntity {
        return investimentDao.retrieveCachedSimulation().first()
    }

    fun saveSimulation(investimentEntity: SimulationInvestimentEntity) {
        investimentDao.cacheSimulationInvestiment(investimentEntity)
    }
}