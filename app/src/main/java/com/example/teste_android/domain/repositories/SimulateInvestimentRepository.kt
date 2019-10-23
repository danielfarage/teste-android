package com.example.teste_android.domain.repositories

import com.example.teste_android.data.entities.SimulationInvestimentEntity
import com.example.teste_android.data.entities.SimulationInvestimentResult

interface SimulateInvestimentRepository {

    suspend fun doSimulationInvestiment(): SimulationInvestimentResult

    suspend fun retrieveSimulationFromDB(): SimulationInvestimentEntity

    suspend fun saveSimulationToDB(investimentEntity: SimulationInvestimentEntity): Long
}