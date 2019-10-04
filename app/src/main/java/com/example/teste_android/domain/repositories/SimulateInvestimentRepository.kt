package com.example.teste_android.domain.repositories

import com.example.teste_android.data.entities.SimulationInvestimentResult

interface SimulateInvestimentRepository {

    suspend fun doSimulationInvestiment(): SimulationInvestimentResult

    fun retrieveSimulationFromDB()

    fun saveSimulationToDB()
}