package com.example.teste_android.presentation.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.teste_android.data.entities.SimulationInvestimentResult
import com.example.teste_android.domain.usecases.contracts.SimulateInvestimentUseCase
import com.example.teste_android.presentation.common.Failure
import com.example.teste_android.presentation.common.Loading
import com.example.teste_android.presentation.common.SuccessNoData
import com.example.teste_android.presentation.common.UIStates
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyString

@RunWith(JUnit4::class)
class InputDataViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    val useCase: SimulateInvestimentUseCase = mockk()
    val simulationResult: SimulationInvestimentResult = mockk()
    val observer = mockk<Observer<UIStates>>(relaxed = true)
    lateinit var viewModel: InputDataViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = InputDataViewModel(useCase)
        viewModel.updatedState.observeForever(observer)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
    }

    @Test
    fun launchSimulation_verifyIfSimulationIsCalled() = runBlockingTest {


        coEvery {
            useCase.launchSimulation()
        } coAnswers { SuccessNoData }

        //act
        viewModel.launchInvestiment(anyString(), anyString(), anyString())


        verify(exactly = 1) {
            observer.onChanged(Loading)
            observer.onChanged(SuccessNoData)
        }
        assertEquals(SuccessNoData, viewModel.updatedState.value)
    }

    @Test
    fun launchSimulation_verifyIfFailure() {
        coEvery { useCase.launchSimulation() } coAnswers { Failure(mockk(relaxed = true)) }

        viewModel.launchInvestiment(anyString(), anyString(), anyString())

        verify(exactly = 2) {
            observer.onChanged(any<UIStates>())
        }
        assertNotNull(viewModel.updatedState.value)
    }


}