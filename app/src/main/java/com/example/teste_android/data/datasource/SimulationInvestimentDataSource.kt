package com.example.teste_android.data.datasource

import com.example.teste_android.data.entities.SimulationInvestimentResult

interface SimulationInvestimentDataSource {

    suspend fun retrieveSimulation(): SimulationInvestimentResult

    fun saveSimulation()

}