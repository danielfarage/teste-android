package com.example.teste_android.data.repository

import com.example.teste_android.data.datasource.SimulationInvestimentLocalDataSource
import com.example.teste_android.data.datasource.SimulationInvestimentRemoteDataSource
import com.example.teste_android.data.entities.SimulationInvestimentEntity
import com.example.teste_android.data.entities.SimulationInvestimentResult
import com.example.teste_android.domain.repositories.SimulateInvestimentRepository

class SimulateInvestimentRepositoryImpl(
    private val remoteDataSource: SimulationInvestimentRemoteDataSource,
    private val localDataSource: SimulationInvestimentLocalDataSource
) : SimulateInvestimentRepository {

    override suspend fun doSimulationInvestiment(): SimulationInvestimentResult {
        return remoteDataSource.retrieveSimulation()
    }

    override fun retrieveSimulationFromDB() {
        TODO()
    }


    override fun saveSimulationToDB(investimentEntity: SimulationInvestimentEntity) {
        localDataSource.saveSimulation(investimentEntity)
    }
}