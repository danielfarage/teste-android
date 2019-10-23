package com.example.teste_android.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.teste_android.data.entities.SimulationInvestimentEntity

@Dao
interface SimulationInvestimentDao {

    @Insert
    fun cacheSimulationInvestiment(investimentEntity: SimulationInvestimentEntity): Long

    @Query("SELECT * FROM SimulationInvestimentEntity ORDER BY id DESC")
    fun retrieveCachedSimulation(): List<SimulationInvestimentEntity>


}