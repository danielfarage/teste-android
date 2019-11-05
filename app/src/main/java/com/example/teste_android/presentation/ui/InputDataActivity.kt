package com.example.teste_android.presentation.ui

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.widget.doAfterTextChanged
import com.example.teste_android.R
import com.example.teste_android.presentation.common.*
import com.example.teste_android.presentation.viewmodels.InputDataViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_input_data.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class InputDataActivity : AppCompatActivity() {

    private val inputViewModel: InputDataViewModel by viewModel()
    private val loadingComponent: DialogLoading by inject()
    private val loading: Dialog by lazy { loadingComponent.createLoading(this) }
    private lateinit var moneyApplied: EditText
    private lateinit var endOfInvestiment: EditText
    private lateinit var cdiPercent: EditText
    private lateinit var buttonSimulate: Button
    private lateinit var layoutWrapper: ConstraintLayout
    private val calendar = Calendar.getInstance()
    private val year = calendar.get(Calendar.YEAR)
    private val month = calendar.get(Calendar.MONTH)
    private val day = calendar.get(Calendar.DAY_OF_MONTH)
    private lateinit var calendarDialog: DatePickerDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_data)
        setupViews()
        setupListeners()
        observeViewModel()
        calendarDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { _, yearPicked, monthPicked, dayPicked ->
                endOfInvestiment.setText("$dayPicked/${monthPicked+1}/$yearPicked")
            }, year, month, day)
    }

    private fun observeViewModel() {
        inputViewModel.updatedState.observe(this, androidx.lifecycle.Observer { state ->
            when(state) {
                is UIStates.Loading -> loading.show()
                is UIStates.Failure -> simulationInvestimentFailure(state.error)
                is UIStates.SuccessNoData -> simulationInvestimentSuccessful()
            }
        })
    }

    private fun setupViews() {
        moneyApplied = et_money_applied
        endOfInvestiment = et_end_investment
        cdiPercent = et_cdi_percent
        buttonSimulate = btn_simulate
        layoutWrapper = layout_input_data
    }

    private fun simulationInvestimentSuccessful() {
        loading.hide()
        val showSimulationScreen = Intent(this, SimulationActivity::class.java)
        startActivity(showSimulationScreen)
    }

    private fun simulationInvestimentFailure(error: Exception) {
        loading.hide()
        Snackbar.make(layoutWrapper, error.message!!, Snackbar.LENGTH_SHORT).show()
    }

    private fun setupListeners() {

        buttonSimulate.setOnClickListener {
            inputViewModel.launchInvestiment(
                moneyApplied.text.toString(),
                cdiPercent.text.toString(),
                endOfInvestiment.text.toString()
            )
        }

        moneyApplied.addTextChangedListener(moneyFormatterListener)

        cdiPercent.doAfterTextChanged { checkEditTextsToEnableContinue() }

        endOfInvestiment.run {
            isFocusable = false
            doAfterTextChanged { checkEditTextsToEnableContinue() }
            setOnClickListener {
                closeSoftKeyboard()
                calendarDialog.show()
            }
        }
    }

    private fun checkEditTextsToEnableContinue() {
        btn_simulate.isEnabled = (moneyApplied.text.isNotEmpty()
                && endOfInvestiment.text.isNotEmpty()
                && cdiPercent.text.isNotEmpty())
    }

    private val moneyFormatterListener = object : TextWatcher {
        var editedText: String = ""

        override fun onTextChanged(newValue: CharSequence?, p1: Int, p2: Int, p3: Int) {
            if (editedText != newValue.toString()) {
                moneyApplied.removeTextChangedListener(this)

                val formatted = newValue
                    .toString()
                    .toMoneyMask()
                editedText = formatted
                moneyApplied.apply {
                    setText(formatted)
                    setSelection(formatted.length)
                }
                moneyApplied.addTextChangedListener(this)
            }
        }

        override fun afterTextChanged(editable: Editable?) = checkEditTextsToEnableContinue()

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int)  = Unit
    }

    override fun onDestroy() {
        super.onDestroy()
        calendarDialog.dismiss()
    }
}
