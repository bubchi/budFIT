package com.example.budfit
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click

import androidx.test.espresso.assertion.PositionAssertions.isRightOf
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import junit.framework.Assert.assertEquals
import org.hamcrest.Matcher
import org.junit.Before
import java.util.regex.Pattern.matches

@RunWith(AndroidJUnit4::class)
@LargeTest
public class MainTest {


    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    var mnozstvoVody = 0


    fun getText(matcher: ViewInteraction): String {
        var text = String()
        matcher.perform(object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return isAssignableFrom(TextView::class.java)
            }

            override fun getDescription(): String {
                return "Text of the view"
            }

            override fun perform(uiController: UiController, view: View) {
                val tv = view as TextView
                text = tv.text.toString()
            }
        })

        return text
    }

    @Test
    fun resetDataTest() {
        onView(withId(R.id.resetData)).perform(click())

        val voda: ViewInteraction = onView(withId(R.id.vodaText))
        val jedlo: ViewInteraction = onView(withId(R.id.kcalJedlo))
        val cvicenie: ViewInteraction = onView(withId(R.id.cvicenieTextView))

        assertEquals("voda", getText(voda))
        assertEquals("jedlo", getText(jedlo))
        assertEquals("cvicenie", getText(cvicenie))
    }

    @Test
    public fun addWater() {
        onView(withId(R.id.vodaButton)).perform(click())
        mnozstvoVody = mnozstvoVody + 1

        onView(withId(R.id.vodaButton)).check(isRightOf(withId(R.id.vodaText) ))

        val cv: ViewInteraction = onView(withId(R.id.vodaText))
        val c = getText(cv)

        assertEquals("vypite pohare vody: " + mnozstvoVody, c)
    }


    @Test
    public fun cvicenie() {
        onView(withId(R.id.cvicenieButton)).perform(click())
        //intended(hasComponent(Dialog::class.java!!.getName()))
    }

    /*@Test
    public fun testOpenBMI() {
        onView(withId(R.id.button)).perform(click())
        intended(hasComponent(BMI::class.java!!.getName()))
    }

    @Test
    public fun testOpenAddKcal() {
        onView(withId(R.id.vyberJedlaButton)).perform(click())
        intended(hasComponent(VyberJedlaActivity::class.java!!.getName()))
    }*/


}