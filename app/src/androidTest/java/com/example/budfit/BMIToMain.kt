package com.example.budfit

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class BMIToMain {

    @get:Rule
    val activityRule = ActivityScenarioRule(BMI::class.java)

    @Rule
    @JvmField
    val mainActivityRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun backOnMainActivity() {
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        Intents.intended(IntentMatchers.hasComponent(MainActivity::class.java!!.getName()))
    }
}