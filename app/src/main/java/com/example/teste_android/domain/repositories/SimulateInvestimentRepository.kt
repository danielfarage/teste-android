package com.example.teste_android.domain.repositories

interface SimulateInvestimentRepository {

    fun doSimulationInvestiment()

    fun retrieveSimulationFromDB()

    fun saveSimulationToDB()
}