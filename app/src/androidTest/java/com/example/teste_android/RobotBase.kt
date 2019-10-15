package com.example.teste_android

import android.widget.DatePicker
import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.PickerActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.CoreMatchers.*
import org.koin.ext.getFullName

abstract class RobotBase {

    fun fillEditText(@IdRes resId: Int, text: String): ViewInteraction = onView(withId(resId))
        .perform(ViewActions.replaceText(text), ViewActions.closeSoftKeyboard())

    fun clickButton(resId: Int): ViewInteraction = onView(withId(resId)).perform(click())

    fun setDate(year: Int, month: Int, day: Int): ViewInteraction =
        onView(withClassName(equalTo(DatePicker::class.getFullName()))).perform(PickerActions.setDate(year, month, day))

    fun textView(resId: Int): ViewInteraction = onView(withId(resId))

    fun matchText(viewInteraction: ViewInteraction, text: String): ViewInteraction = viewInteraction.
        check(ViewAssertions.matches(ViewMatchers.withText(text)))

    fun matchText(resId: Int, text: String): ViewInteraction = matchText(textView(resId), text)

    fun clickListItem(listResId: Int, position: Int) {
        onData(anything())
            .inAdapterView(allOf(withId(listResId)))
            .atPosition(position).perform(click())
    }
}