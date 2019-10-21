package com.example.teste_android.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.teste_android.R
import com.example.teste_android.presentation.viewmodels.SimulationViewModel
import org.koin.android.ext.android.inject

class SimulationActivity: AppCompatActivity() {

    private val simulatedViewModel: SimulationViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulation)
        simulatedViewModel.retrieveInvestiment()
    }

    private fun observeSimulatedView() {
        simulatedViewModel.simulatedInvestiment.observe(this, Observer {  })
    }

}