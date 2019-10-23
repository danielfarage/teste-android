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
    private val state = MutableLiveData<UIStates<Nothing>>()
    val updatedState: LiveData<UIStates<Nothing>>
        get() = state


    fun launchInvestiment(investedAmount: String, cdiRate: String, expiryDate: String) {
        val newInvest = Invest(investedAmount, cdiRate, expiryDate)
        invest.postValue(newInvest)
        simulateInvestiment()
    }

    private fun simulateInvestiment() {
        state.postValue(UIStates.Loading(true))

        viewModelScope.launch {
            val simulatedData = simulateUseCase.launchSimulation()
            handleUseCaseResponse(simulatedData)
        }

    }

    private fun handleUseCaseResponse(response: UIStates<Nothing>) {
        when (response) {
            is UIStates.SuccessNoData -> state.postValue(response)
            is UIStates.Failure -> state.postValue(response)
        }
    }

}