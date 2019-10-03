package com.example.teste_android.data.api

import com.example.teste_android.presentation.common.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSetup {
    val retrofit = Retrofit.Builder().apply {
        baseUrl(Constants.BASE_URL)
        addConverterFactory(GsonConverterFactory.create())
    }.build()

}