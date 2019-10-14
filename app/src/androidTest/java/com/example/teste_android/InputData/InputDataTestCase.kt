package com.example.teste_android.InputData

import org.junit.Test

class InputDataTestCase {

    @Test
    fun successfullFlow() {
        invest {
            setMoneyToApplied("1000")
            setEndInvestiment(2019, 10, 15)
            setCDIPercent("100")
        }
    }

}