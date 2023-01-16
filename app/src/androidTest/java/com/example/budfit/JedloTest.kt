package com.example.budfit


import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.PositionAssertions.isLeftOf
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withSpinnerText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.CoreMatchers.anything
import org.hamcrest.Matchers.hasToString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class JedloTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(VyberJedlaActivity::class.java)

    @Test
    public fun gramsPositions() {
        onView(withId(R.id.maso)).check(isLeftOf(withId(R.id.mnozstvoJedla)))
    }

    @Test
    public fun kcalTofu() {
        onView(withId(R.id.maso)).perform()
        onData(hasToString("tofu")).perform(click())
        //onData(anything()).atPosition(2).perform(click())
    }
}