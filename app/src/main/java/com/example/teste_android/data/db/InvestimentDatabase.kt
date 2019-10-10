package com.example.teste_android.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.teste_android.data.dao.SimulationInvestimentDao
import com.example.teste_android.data.entities.SimulationInvestimentEntity

@Database(entities = arrayOf(SimulationInvestimentEntity::class), version = 1)
abstract class InvestimentDatabase: RoomDatabase() {
    abstract fun investimentDao(): SimulationInvestimentDao
}