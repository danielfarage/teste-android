package com.example.teste_android.presentation.common

sealed class UIStates

object Loading : UIStates()
data class SuccessWithData<T>(val data: T): UIStates()
object SuccessNoData: UIStates()
data class Failure(val error: Exception): UIStates()
