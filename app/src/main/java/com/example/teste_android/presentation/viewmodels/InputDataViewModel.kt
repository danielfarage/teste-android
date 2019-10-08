package com.example.teste_android.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teste_android.domain.usecases.SimulateInvestimentUseCase
import com.example.teste_android.presentation.common.*
import com.example.teste_android.presentation.entities.Invest
import kotlinx.coroutines.launch
import org.koin.core.KoinApplication

class InputDataViewModel(private val simulateUseCase: SimulateInvestimentUseCase) : ViewModel() {

    private val invest = MutableLiveData<Invest>()
    private val state = MutableLiveData<UIStates>()
    val updatedState:LiveData<UIStates>
        get() = state


    fun launchInvestiment(investedAmount: String, cdiRate: String, expiryDate: String) {
        val newInvest = Invest(investedAmount, cdiRate, expiryDate)
        invest.postValue(newInvest)
        simulateInvestiment()
    }

    private fun simulateInvestiment(){
        state.postValue(Loading)
        viewModelScope.launch {
            try {
                val simulatedData = simulateUseCase.launchSimulation()
                KoinApplication.logger.info(simulatedData.toString())
                state.postValue(SuccessNoData)
            } catch (e: Exception) {
                state.postValue(Failure(e))
                e.message?.let { KoinApplication.logger.info(it) }
            }

        }

    }

}