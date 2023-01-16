package com.example.budfit

//import androidx.core.content.MimeTypeFilter.matches
import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.PositionAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.EnumSet.allOf
//import java.util.regex.Pattern.matches
import org.hamcrest.core.StringContains.containsString
//import androidx.test.espresso.matcher.ViewMatchers.withText


@RunWith(AndroidJUnit4::class)
@LargeTest
class BMITest {
    @get:Rule
    val activityRule = ActivityScenarioRule(BMI::class.java)




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
    public fun calculateUnderweight() {
        onView(ViewMatchers.withId(R.id.editTextVyska)).perform(typeText("120"))
        //onView(withId(R.id.vodaText)).check(matches(withText("Hello Espresso!")))
        onView(ViewMatchers.withId(R.id.editTextTextVaha)).perform(typeText("5"))
        onView(ViewMatchers.withId(R.id.VypocitajButton)).perform(click())

        val vysledokBMI: ViewInteraction = onView(withId(R.id.KomentarBMI))
        val v = getText(vysledokBMI)

        onView(withText("podla BMI mas nizku vahu")).check(matches(isDisplayed()))
        //assertEquals("podla BMI mas nizku vahu", v)

        //onView(withText("vahu")).check(matches(isDisplayed()))
//        assertThat(onView(withId(R.id.KomentarBMI)).check(matches(withText("")))
//        onView(withContentDescription("nizku"))
//        onView(withText(R.id.KomentarBMI.toString()))
//        onView(withId(R.id.KomentarBMI)).check())
        //assertThat(R.id.KomentarBMI.toString(), containsString("nizku"))
        //onView(withText("podla BMI mas nizku vahu")).check(matches(isDisplayed()))
    }
}