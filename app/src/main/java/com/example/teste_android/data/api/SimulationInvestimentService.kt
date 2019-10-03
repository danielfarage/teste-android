package com.example.teste_android.data.api

import retrofit2.http.GET

interface SimulationInvestimentService {

    @GET
    fun retrieveSimulation()

}