package com.example.teste_android.data.db

import android.content.Context
import androidx.room.Room

class RoomClient(val context: Context) {
    val db: InvestimentDatabase by lazy {
        Room.databaseBuilder(
            context,
            InvestimentDatabase::class.java,
            "InvestimentSimulation"
        ).build()
    }
}