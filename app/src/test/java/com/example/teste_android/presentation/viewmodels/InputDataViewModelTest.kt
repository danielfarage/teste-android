package com.example.teste_android.presentation.viewmodels

import com.example.teste_android.data.entities.SimulationInvestimentResult
import com.example.teste_android.domain.usecases.SimulateInvestimentUseCase
import com.example.teste_android.presentation.common.Loading
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class InputDataViewModelTest {

    val useCase: SimulateInvestimentUseCase = mockk()
    val viewModel = InputDataViewModel(useCase)

    @Test
    fun launchSimulation_verifyIfSimulationIsCalled() {
        //viewModel.updatedState.observeForever {}
        coEvery {
            useCase.launchSimulation()
        }.returns(mockk(relaxed = true))
        //act
        viewModel.launchInvestiment("", "", "")
        assertEquals(Loading, viewModel.updatedState.value)
    }

}