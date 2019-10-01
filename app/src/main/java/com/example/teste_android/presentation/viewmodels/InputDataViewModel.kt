package com.example.teste_android.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teste_android.presentation.common.UIStates
import com.example.teste_android.presentation.entities.Invest
import kotlinx.coroutines.launch

class InputDataViewModel() : ViewModel() {

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
        state.postValue(UIStates.Loading)
        // call use case
    }

}