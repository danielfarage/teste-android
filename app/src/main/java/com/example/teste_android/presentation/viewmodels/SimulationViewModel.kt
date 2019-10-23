package com.example.teste_android.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teste_android.domain.usecases.contracts.SimulatedUseCase
import com.example.teste_android.presentation.common.UIStates
import com.example.teste_android.presentation.entities.SimulatedInvestiment
import kotlinx.coroutines.launch

class SimulationViewModel(private val simulatedUseCase: SimulatedUseCase): ViewModel() {

    private val invested = MutableLiveData<UIStates<SimulatedInvestiment>>()
    val simulatedInvestiment: LiveData<UIStates<SimulatedInvestiment>>
        get() = invested

    fun retrieveInvestiment() {
        viewModelScope.launch {
            val simulatedResult = simulatedUseCase.retrieveSimulatedInvestiment()
            invested.postValue(UIStates.SuccessWithData(simulatedResult))
        }
    }

}