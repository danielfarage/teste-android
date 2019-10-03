package com.example.teste_android.presentation.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.teste_android.R
import com.example.teste_android.presentation.common.toMoney
import com.example.teste_android.presentation.viewmodels.InputDataViewModel
import kotlinx.android.synthetic.main.activity_input_data.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class InputDataActivity : AppCompatActivity() {

    val inputViewModel: InputDataViewModel by viewModel()
    private lateinit var moneyApplied: EditText
    private lateinit var endOfInvestiment: EditText
    private lateinit var cdiPercent: EditText
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_data)
        setupViews()
        setupListeners()
        inputViewModel.launchInvestiment("", "", "")
    }

    private fun setupViews() {
        moneyApplied = et_money_applied
        endOfInvestiment = et_end_investment
        cdiPercent = et_cdi_percent
    }

    private fun setupListeners() {
        moneyApplied.addTextChangedListener(moneyFormatterListener)

        cdiPercent.doAfterTextChanged { checkEditTextsToEnableContinue() }

        endOfInvestiment.run {
            isFocusable = false
            doAfterTextChanged { checkEditTextsToEnableContinue() }
            setOnClickListener {
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val day = calendar.get(Calendar.DAY_OF_MONTH)
                DatePickerDialog(
                    context,
                    DatePickerDialog.OnDateSetListener { _, yearPicked, monthPicked, dayPicked ->

                        endOfInvestiment.setText("$dayPicked/${monthPicked+1}/$yearPicked")

                    },
                    year,
                    month,
                    day
                ).show()
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
                    .toMoney()
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
}
