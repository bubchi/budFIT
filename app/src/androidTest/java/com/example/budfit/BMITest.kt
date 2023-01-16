package com.example.budfit

//import androidx.core.content.MimeTypeFilter.matches
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
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
import org.hamcrest.CoreMatchers.containsString
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

    @Test
    public fun calculateUnderweight() {



        onView(ViewMatchers.withId(R.id.editTextVyska)).perform(typeText("120"))
        //onView(withId(R.id.vodaText)).check(matches(withText("Hello Espresso!")))
        onView(ViewMatchers.withId(R.id.editTextTextVaha)).perform(typeText("5"))
        onView(ViewMatchers.withId(R.id.VypocitajButton)).perform(click())



        onView(withText("vahu")).check(matches(isDisplayed()))
//        assertThat(onView(withId(R.id.KomentarBMI)).check(matches(withText("")))
//        onView(withContentDescription("nizku"))
//        onView(withText(R.id.KomentarBMI.toString()))
//        onView(withId(R.id.KomentarBMI)).check())
        //assertThat(R.id.KomentarBMI.toString(), containsString("nizku"))
        //onView(withText("podla BMI mas nizku vahu")).check(matches(isDisplayed()))
    }
}