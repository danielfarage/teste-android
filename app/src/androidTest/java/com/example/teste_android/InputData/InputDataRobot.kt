package com.example.teste_android.InputData

import com.example.teste_android.R
import com.example.teste_android.RobotBase

class InputDataRobot: RobotBase() {

    fun setMoneyToApplied(money: String) = fillEditText(R.id.et_money_applied, money)

    fun setEndInvestiment(year: Int, month: Int, day: Int) {
        clickButton(R.id.et_end_investment)
        setDate(year, month, day)
    }

    fun setCDIPercent(cdiTax: String) = fillEditText(R.id.et_cdi_percent, cdiTax)


}


fun invest(func: InputDataRobot.() -> Unit) = InputDataRobot().apply(func)