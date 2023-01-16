package com.example.budfit

//import androidx.core.content.MimeTypeFilter.matches
//import java.util.regex.Pattern.matches

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.PositionAssertions.isAbove
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.google.android.material.internal.ContextUtils.getActivity
import junit.framework.Assert
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


//import androidx.test.espresso.matcher.ViewMatchers.withText



@RunWith(AndroidJUnit4::class)
@LargeTest
class BMITest {




    @get:Rule
    val activityRule = ActivityScenarioRule(BMI::class.java)


    @Rule
    @JvmField
    val mainActivityRule = IntentsTestRule(MainActivity::class.java)

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
    fun testPositions() {

        onView(withId(R.id.textView)).check(isAbove(withId(R.id.editTextVyska)))
        onView(withId(R.id.editTextVyska)).check(isAbove(withId(R.id.editTextTextVaha)))
        onView(withId(R.id.editTextTextVaha)).check(isAbove(withId(R.id.editTextVek)))
        onView(withId(R.id.editTextVek)).check(isAbove(withId(R.id.VypocitajButton)))
    }

    @Test
    public fun calculateUnderweight() {
        onView(ViewMatchers.withId(R.id.editTextVyska)).perform(typeText("120"))

        onView(ViewMatchers.withId(R.id.editTextTextVaha)).perform(typeText("5"))
        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(ViewMatchers.withId(R.id.VypocitajButton)).perform(click())

        val vysledokBMI: ViewInteraction = onView(withId(R.id.KomentarBMI))
        val v = getText(vysledokBMI)

        onView(withText("podla BMI mas nizku vahu")).check(matches(isDisplayed()))
    }

    @Test
    public fun calculateOverweight() {
        onView(ViewMatchers.withId(R.id.editTextVyska)).perform(typeText("120"))
        //onView(withId(R.id.vodaText)).check(matches(withText("Hello Espresso!")))
        onView(ViewMatchers.withId(R.id.editTextTextVaha)).perform(typeText("120"))
        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(ViewMatchers.withId(R.id.VypocitajButton)).perform(click())

        val vysledokBMI: ViewInteraction = onView(withId(R.id.KomentarBMI))
        val v = getText(vysledokBMI)

        onView(withText("podla BMI mas nadvahu")).check(matches(isDisplayed()))
    }

    @Test
    public fun calculateNormalweight() {
        onView(ViewMatchers.withId(R.id.editTextVyska)).perform(typeText("170"))
        onView(ViewMatchers.withId(R.id.editTextTextVaha)).perform(typeText("65"))
        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(ViewMatchers.withId(R.id.VypocitajButton)).perform(click())

        val vysledokBMI: ViewInteraction = onView(withId(R.id.KomentarBMI))
        val v = getText(vysledokBMI)

        onView(withText("podla BMI mas vahu v norme")).check(matches(isDisplayed()))
    }

    @Test
    fun backOnMainActivity() {

        onView(isRoot()).perform(ViewActions.pressBack())
        Intents.intended(IntentMatchers.hasComponent(MainActivity::class.java!!.getName()))

    }

    @Test
    fun noDataAddedToast() {
        onView(ViewMatchers.withId(R.id.VypocitajButton)).perform(click())

        val title: ViewInteraction = onView(withId(R.id.textView))

        Assert.assertEquals("Napis prosim svoje udaje pre vypocet BMI" , getText(title))
        //onView(withText("Napis prosim svoje udaje pre vypocetBMI")).check(matches(isDisplayed()))
        //onView(withText("Zadaj udaje najprv")).check(isDisplayed())
        //onView(withText("Zadaj udaje najprv")).check(matches(isDisplayed()))
    }
}