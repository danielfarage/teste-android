package com.example.teste_android.presentation.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.teste_android.R
import com.example.teste_android.presentation.common.toMoney
import kotlinx.android.synthetic.main.activity_input_data.*
import java.util.*

class InputDataActivity : AppCompatActivity() {

    private lateinit var moneyApplied: EditText
    private lateinit var endOfInvestiment: EditText
    private lateinit var cdiPercent: EditText
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_data)
        setupViews()
        setupListeners()
    }

    private fun setupViews() {
        moneyApplied = et_money_applied
        endOfInvestiment = et_end_investment
        cdiPercent = et_cdi_percent
    }

    private fun setupListeners() {
        moneyApplied.addTextChangedListener(object : TextWatcher {
            var editedText: String = ""

            override fun afterTextChanged(editable: Editable?) {
                //do nothing
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //do nothing
            }

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
        })

        endOfInvestiment.run {
            isFocusable = false
            setOnClickListener {
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val day = calendar.get(Calendar.DAY_OF_MONTH)
                DatePickerDialog(
                    context,
                    DatePickerDialog.OnDateSetListener { view, yearPicked, monthPicked, dayPicked ->

                        endOfInvestiment.setText("$day/$monthPicked/$year")

                    },
                    year,
                    month,
                    day
                ).show()
            }
        }

    }
}
