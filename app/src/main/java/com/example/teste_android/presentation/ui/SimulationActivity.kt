package com.example.teste_android.presentation.ui

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannedString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.teste_android.R
import com.example.teste_android.presentation.common.UIStates
import com.example.teste_android.presentation.entities.SimulatedInvestiment
import com.example.teste_android.presentation.viewmodels.SimulationViewModel
import kotlinx.android.synthetic.main.activity_simulation.*
import kotlinx.android.synthetic.main.simulation_block_one.*
import kotlinx.android.synthetic.main.simulation_block_two.*
import org.koin.android.ext.android.inject
import java.lang.Exception

class SimulationActivity: AppCompatActivity() {

// O valor a ser investido
private lateinit var investedAmount: TextView

private lateinit var grossAmountProfitTitle: TextView
// Rentabilidade anual
private lateinit var yearlyInterestRate: TextView
// Dias corridos
private lateinit var maturityTotalDays: TextView
// Data de vencimento
private lateinit var maturityDate: TextView
// Percentual do papel
private lateinit var rate: TextView

// Valor bruto do investimento
private lateinit var grossAmount: TextView
// Valor do IR
private lateinit var taxesAmount: TextView
// Valor líquido
private lateinit var netAmount: TextView
// Rentabilidade bruta
private lateinit var grossAmountProfit: TextView
// Rentabilidade líquida
private lateinit var netAmountProfit: TextView
// Rentabilidade bruta anual
private lateinit var annualGrossRateProfit: TextView
// Rentabilidade bruta mensal
private lateinit var monthlyGrossRateProfit: TextView
// Rentabilidade no período
private lateinit var rateProfit: TextView

    private val simulatedViewModel: SimulationViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulation)
        setupViews()
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
            //is UIStates.Loading -> showLoadingDialog(state.showLoad)
            is UIStates.SuccessNoData -> informNoDataFound()
        }
    }

    private fun renderScreenInformations(investiment: SimulatedInvestiment) {
        grossAmountProfitTitle.text = investiment.grossAmount
        yearlyInterestRate.text = investiment.investmentParameter.yearlyInterestRate
        maturityTotalDays.text = investiment.investmentParameter.maturityTotalDays
        maturityDate.text = investiment.investmentParameter.maturityDate
        rate.text = investiment.investmentParameter.rate
        grossAmount.text = investiment.grossAmount
        taxesAmount.text = investiment.taxesAmount
        netAmount.text = investiment.netAmount
        val spannedStringGrossAmount = SpannableString(getString(R.string.rendimento_total_de, investiment.grossAmountProfit) )
        spannedStringGrossAmount.setSpan(ForegroundColorSpan( resources.getColor(R.color.colorAccent) ), 20, spannedStringGrossAmount.count(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        grossAmountProfit.text = spannedStringGrossAmount
        netAmountProfit.text = investiment.netAmountProfit
        annualGrossRateProfit.text = investiment.annualGrossRateProfit
        monthlyGrossRateProfit.text = investiment.monthlyGrossRateProfit
        rateProfit.text = investiment.rateProfit
        investedAmount.text = investiment.investmentParameter.investedAmount
    }

    private fun renderScreenErrorOccurred(failure: Exception) {

    }

    private fun showLoadingDialog(showLoad: Boolean) {

    }

    private fun informNoDataFound(){

    }

    private fun setupViews() {
        grossAmountProfitTitle = tv_grossAmountProfitTitle
        yearlyInterestRate = tv_rentabilidade_anual
        maturityTotalDays = tv_dias_corridos
        maturityDate = tv_data_resgate
        rate = tv_percentual_cdi
        grossAmount = tv_valor_bruto
        taxesAmount = tv_ir_investimento
        netAmount = tv_valor_liquido
        grossAmountProfit = tv_grossAmountProfit
        netAmountProfit = tv_valor_rendimento
        annualGrossRateProfit = tv_rentabilidade_anual
        monthlyGrossRateProfit = tv_rendimento_mensal
        rateProfit = tv_rentabilidade_periodo
        investedAmount = tv_valor_aplicado
    }

}