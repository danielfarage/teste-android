package com.example.teste_android.presentation.common

sealed class UIStates<T> {
    data class Loading<T>(val showLoad: Boolean) : UIStates<T>()
    data class SuccessWithData<T>(val data: T) : UIStates<T>()
    class  SuccessNoData<T> : UIStates<T>()
    data class Failure<T>(val error: Exception) : UIStates<T>()
}


