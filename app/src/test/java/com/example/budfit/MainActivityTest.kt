package com.example.budfit


import android.view.View.OnClickListener
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
//import androidx.test.filters.LargeTest
import androidx.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.onView

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches


@RunWith(AndroidJUnit4::class)
@LargeTest

class HelloWorldEspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test fun listGoesOverTheFold() {
        onView(withText("Hello world!")).check(matches(isDisplayed()))
    }
}
/*
class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
    scenario = launchActivity()
        scenario.moveToState(Lifecycle.State.STARTED)

}
    @Test
    fun testOpenBMI() {

        onView()

    }

}*/
