package com.example.teste_android.presentation.di

import com.example.teste_android.data.api.RetrofitSetup
import com.example.teste_android.data.api.SimulationInvestimentService
import com.example.teste_android.data.datasource.SimulationInvestimentLocalDataSource
import com.example.teste_android.data.datasource.SimulationInvestimentRemoteDataSource
import com.example.teste_android.data.db.RoomClient
import com.example.teste_android.data.repository.SimulateInvestimentRepositoryImpl
import com.example.teste_android.domain.repositories.SimulateInvestimentRepository
import com.example.teste_android.domain.usecases.SimulateInvestimentUseCaseImpl
import com.example.teste_android.domain.usecases.SimulatedUseCaseImpl
import com.example.teste_android.domain.usecases.contracts.SimulateInvestimentUseCase
import com.example.teste_android.domain.usecases.contracts.SimulatedUseCase
import com.example.teste_android.presentation.common.DialogLoading
import com.example.teste_android.presentation.viewmodels.InputDataViewModel
import com.example.teste_android.presentation.viewmodels.SimulationViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModules = module {

    viewModel { InputDataViewModel(get()) }

    viewModel { SimulationViewModel(get()) }

    factory<SimulateInvestimentUseCase> { SimulateInvestimentUseCaseImpl(get()) }

    factory<SimulatedUseCase> { SimulatedUseCaseImpl(get()) }

    single<SimulateInvestimentRepository> { SimulateInvestimentRepositoryImpl(get(), get()) }

    single<SimulationInvestimentService> { RetrofitSetup.retrofit.create(SimulationInvestimentService::class.java) }

    single { SimulationInvestimentRemoteDataSource(get()) }

    single { SimulationInvestimentLocalDataSource(get()) }

    single { DialogLoading }

    single { RoomClient(get()).db }
}

