package com.example.teste_android.data.repository

import com.example.teste_android.data.datasource.SimulationInvestimentRemoteDataSource
import com.example.teste_android.data.entities.SimulationInvestimentResult
import com.example.teste_android.domain.repositories.SimulateInvestimentRepository

class SimulateInvestimentRepositoryImpl(
    private val remoteDataSource: SimulationInvestimentRemoteDataSource
) : SimulateInvestimentRepository {

    override suspend fun doSimulationInvestiment(): SimulationInvestimentResult {
        return remoteDataSource.retrieveSimulation()
    }

    override fun retrieveSimulationFromDB() = Unit


    override fun saveSimulationToDB() = Unit
}