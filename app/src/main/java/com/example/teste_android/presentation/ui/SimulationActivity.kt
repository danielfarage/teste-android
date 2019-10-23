package com.example.teste_android.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.teste_android.R
import com.example.teste_android.presentation.common.UIStates
import com.example.teste_android.presentation.entities.SimulatedInvestiment
import com.example.teste_android.presentation.viewmodels.SimulationViewModel
import org.koin.android.ext.android.inject
import java.lang.Exception

class SimulationActivity: AppCompatActivity() {

    private val simulatedViewModel: SimulationViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulation)
        simulatedViewModel.retrieveInvestiment()
    }

    private fun observeSimulatedView() {
        simulatedViewModel.simulatedInvestiment.observe(this, Observer { states ->
            handleStates(states)
        })
    }

    private fun handleStates(state: UIStates<SimulatedInvestiment>) {
        when(state) {
            is UIStates.SuccessWithData -> renderScreenInformations(state.data)
            is UIStates.Failure -> renderScreenErrorOccurred(state.error)
            is UIStates.Loading -> showLoadingDialog(state.showLoad)
            is UIStates.SuccessNoData -> informNoDataFound()
        }
    }

    private fun renderScreenInformations(investiment: SimulatedInvestiment) {

    }

    private fun renderScreenErrorOccurred(failure: Exception) {

    }

    private fun showLoadingDialog(showLoad: Boolean) {

    }

    private fun informNoDataFound(){

    }

}