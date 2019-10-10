package com.example.teste_android.presentation.di

import com.example.teste_android.data.api.RetrofitSetup
import com.example.teste_android.data.api.SimulationInvestimentService
import com.example.teste_android.data.datasource.SimulationInvestimentRemoteDataSource
import com.example.teste_android.data.db.RoomClient
import com.example.teste_android.data.repository.SimulateInvestimentRepositoryImpl
import com.example.teste_android.domain.repositories.SimulateInvestimentRepository
import com.example.teste_android.domain.usecases.SimulateInvestimentInteractor
import com.example.teste_android.domain.usecases.SimulateInvestimentUseCase
import com.example.teste_android.presentation.common.DialogLoading
import com.example.teste_android.presentation.viewmodels.InputDataViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModules = module {

    viewModel { InputDataViewModel(get()) }

    factory<SimulateInvestimentUseCase> { SimulateInvestimentInteractor(get()) }

    single<SimulateInvestimentRepository> { SimulateInvestimentRepositoryImpl(get()) }

    single<SimulationInvestimentService> { RetrofitSetup.retrofit.create(SimulationInvestimentService::class.java) }

    single { SimulationInvestimentRemoteDataSource(get()) }

    single { DialogLoading }

    single { RoomClient(get()).db }
}

