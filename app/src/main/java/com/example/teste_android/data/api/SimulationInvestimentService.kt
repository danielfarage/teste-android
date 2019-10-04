package com.example.teste_android.data.api

import com.example.teste_android.data.entities.SimulationInvestimentResult
import retrofit2.http.GET

interface SimulationInvestimentService {

    @GET("5d82b1ec3400006d00f4a09c/")
    suspend fun retrieveSimulation(): SimulationInvestimentResult

}