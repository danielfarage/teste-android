package com.example.teste_android.data.dao

import androidx.room.Insert
import androidx.room.Query
import com.example.teste_android.data.entities.SimulationInvestimentEntity

interface SimulationInvestimentDao {

    @Insert
    fun cacheSimulationInvestiment(investimentEntity: SimulationInvestimentEntity)

    @Query("SELECT * FROM Invetiment")
    fun retrieveCachedSimulation()


}