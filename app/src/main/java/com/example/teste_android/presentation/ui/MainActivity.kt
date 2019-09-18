package com.example.teste_android.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.widget.EditText
import com.example.teste_android.R
import com.example.teste_android.presentation.common.toMoney
import kotlinx.android.synthetic.main.activity_input_data.*
import org.koin.core.KoinApplication.Companion.logger

class MainActivity : AppCompatActivity() {

    private lateinit var moneyApplied: EditText
    private lateinit var endOfInvestiment: EditText
    private lateinit var cdiPercent: EditText

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
                if(editedText != newValue.toString()) {
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
    }
}
