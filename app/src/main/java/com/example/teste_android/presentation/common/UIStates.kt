package com.example.teste_android.presentation.common

sealed class UIStates {
    object Loading : UIStates()
    data class Success<T>(val data: T): UIStates()
    data class Failure(val error: Exception): UIStates()
}