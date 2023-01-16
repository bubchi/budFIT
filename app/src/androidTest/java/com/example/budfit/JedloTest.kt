package com.example.budfit


import android.view.View
import android.widget.Spinner
import android.widget.TextView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.PositionAssertions.isLeftOf
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withSpinnerText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.anything
import org.hamcrest.Matcher
import org.hamcrest.Matchers.hasToString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class JedloTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(VyberJedlaActivity::class.java)

    fun getText(matcher: ViewInteraction): String {
        var text = String()
        matcher.perform(object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return ViewMatchers.isAssignableFrom(Spinner::class.java)
            }

            override fun getDescription(): String {
                return "Text of the view"
            }

            override fun perform(uiController: UiController, view: View) {
                val tv = view as Spinner
                text = tv.selectedItem.toString()
            }
        })

        return text
    }

    val maso: ViewInteraction = onView(withId(R.id.maso))
    val priloha: ViewInteraction = onView(withId(R.id.priloha))
    val zelenina: ViewInteraction = onView(withId(R.id.zelenina))
    val ovocie: ViewInteraction = onView(withId(R.id.ovocie))
    val obylniny: ViewInteraction = onView(withId(R.id.obylniny))


    @Test
    public fun resetChoices() {
        onView(withId(R.id.vypocitajKcal)).perform(click())
        assertEquals("vybrat maso", getText(maso))
        assertEquals("vybrat priloha", getText(priloha))
        assertEquals("vybrat zeleninu", getText(zelenina))
        assertEquals("vybrat ovocie", getText(ovocie))
        assertEquals("vybrat obylninu", getText(obylniny))
    }

    @Test
    public fun gramsPositions() {
        onView(withId(R.id.maso)).check(isLeftOf(withId(R.id.mnozstvoJedla)))
    }

    @Test
    public fun kcalTofu() {
        onView(withId(R.id.maso)).perform(click())
        var tofu: ViewInteraction = onView(withId(R.id.maso))
        var tofuText = getText(tofu)
        onView(withSpinnerText("tofu")).perform(click())
        //onData(hasToString(getText(tofu))).perform(click())
        //onData(anything()).atPosition(2).perform(click())
    }
}