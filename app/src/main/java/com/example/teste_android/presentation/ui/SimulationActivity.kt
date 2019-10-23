package com.example.teste_android.presentation.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.teste_android.R
import com.example.teste_android.presentation.common.UIStates
import com.example.teste_android.presentation.entities.SimulatedInvestiment
import com.example.teste_android.presentation.viewmodels.SimulationViewModel
import org.koin.android.ext.android.inject
import java.lang.Exception

class SimulationActivity: AppCompatActivity() {

// O valor a ser investido
private val investedAmount: TextView =
// Rentabilidade anual
private val yearlyInterestRate: TextView
// Dias corridos
private val maturityTotalDays: TextView
// Dias úteis
private val maturityBusinessDays: TextView
// Data de vencimento
private val maturityDate: TextView
// Percentual do papel
private val rate: TextView
// Isento de IR
private lateinit var isTaxFree: TextView

// Valor bruto do investimento
private val grossAmount: TextView
// Valor do IR
private val taxesAmount: TextView
// Valor líquido
private val netAmount: TextView
// Rentabilidade bruta
private val grossAmountProfit: TextView
// Rentabilidade líquida
private val netAmountProfit: TextView
// Rentabilidade bruta anual
private val annualGrossRateProfit: TextView
// Rentabilidade bruta mensal
private val monthlyGrossRateProfit: TextView
// Rentabilidade bruta diária
private val dailyGrossRateProfit: TextView
// Faixa do IR (%)
private val taxesRate: TextView
// Rentabilidade no período
private val rateProfit: TextView
// Rentabilidade líquida anual
private val annualNetRateProfit: TextView

    private val simulatedViewModel: SimulationViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulation)
        simulatedViewModel.retrieveInvestiment()
        observeSimulatedView()
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