package com.example.teste_android.InputData

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.teste_android.presentation.ui.InputDataActivity
import org.junit.Rule
import org.junit.Test


class InputDataTestCase {

    @Rule
    @JvmField
    var activityScenarioRule = ActivityScenarioRule(InputDataActivity::class.java)

    @Test
    fun successfullFlow() {
        activityScenarioRule.scenario

        invest {
            setMoneyToApplied("1000")
            setEndInvestiment(2019, 10, 15)
            setCDIPercent("100")
        }
    }

}