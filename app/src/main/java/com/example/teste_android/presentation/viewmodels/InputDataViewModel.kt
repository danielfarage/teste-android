package com.example.teste_android.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teste_android.domain.usecases.contracts.SimulateInvestimentUseCase
import com.example.teste_android.presentation.common.*
import com.example.teste_android.presentation.entities.Invest
import kotlinx.coroutines.launch

class InputDataViewModel(private val simulateUseCase: SimulateInvestimentUseCase) : ViewModel() {

    private val invest = MutableLiveData<Invest>()
    private val state = MutableLiveData<UIStates>()
    val updatedState: LiveData<UIStates>
        get() = state


    fun launchInvestiment(investedAmount: String, cdiRate: String, expiryDate: String) {
        val newInvest = Invest(investedAmount, cdiRate, expiryDate)
        invest.postValue(newInvest)
        simulateInvestiment()
    }

    private fun simulateInvestiment() {
        state.postValue(Loading)

        viewModelScope.launch {
            val simulatedData = simulateUseCase.launchSimulation()
            handleUseCaseResponse(simulatedData)
        }

    }

    private fun handleUseCaseResponse(response: UIStates) {
        when (response) {
            is SuccessNoData -> state.postValue(response)
            is Failure -> state.postValue(response)
        }
    }

}