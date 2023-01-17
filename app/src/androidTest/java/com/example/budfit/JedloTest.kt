package com.example.budfit


import android.view.View
import android.widget.Spinner
import android.widget.TextView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.PositionAssertions.isAbove
import androidx.test.espresso.assertion.PositionAssertions.isLeftOf
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.*
import org.hamcrest.Matcher
import org.hamcrest.Matchers.hasToString
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class JedloTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(VyberJedlaActivity::class.java)


    fun getTextSpinner(matcher: ViewInteraction): String {
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

    val maso: ViewInteraction = onView(withId(R.id.maso))
    val priloha: ViewInteraction = onView(withId(R.id.priloha))
    val zelenina: ViewInteraction = onView(withId(R.id.zelenina))
    val ovocie: ViewInteraction = onView(withId(R.id.ovocie))
    val obylniny: ViewInteraction = onView(withId(R.id.obylniny))


    @Test
    public fun resetChoices() {
        onView(withId(R.id.vypocitajKcal)).perform(click())
        assertEquals("vybrat maso", getTextSpinner(maso))
        assertEquals("vybrat priloha", getTextSpinner(priloha))
        assertEquals("vybrat zeleninu", getTextSpinner(zelenina))
        assertEquals("vybrat ovocie", getTextSpinner(ovocie))
        assertEquals("vybrat obylninu", getTextSpinner(obylniny))
    }

    @Test
    public fun positions() {
        onView(withId(R.id.textView)).check(isAbove(withId(R.id.sumaKalorii)))
        onView(withId(R.id.sumaKalorii)).check(isAbove(withId(R.id.maso)))
        onView(withId(R.id.maso)).check(isLeftOf(withId(R.id.mnozstvoJedla)))
        onView(withId(R.id.maso)).check(isAbove(withId(R.id.priloha)))
        onView(withId(R.id.priloha)).check(isAbove(withId(R.id.zelenina)))
        onView(withId(R.id.zelenina)).check(isAbove(withId(R.id.ovocie)))
        onView(withId(R.id.ovocie)).check(isAbove(withId(R.id.obylniny)))
        onView(withId(R.id.obylniny)).check(isAbove(withId(R.id.vypocitajKcal)))
    }


    private fun selectSpinnerItem(resId: Int, selection: String) {
        onView(withId(resId)).perform(click())
        onData(hasToString(selection)).perform(click())
        onView(withId(resId)).check(matches(withSpinnerText(containsString(selection))))
    }
    @Test
    fun kcalTofu() {
        onView(withId(R.id.maso)).perform(click());
        onData(anything()).atPosition(4).perform(click());
        onView(withId(R.id.maso)).check(matches(withSpinnerText(containsString("tofu"))));

        onView(withId(R.id.mnozstvoJedla)).perform(typeText("100"));
        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.vypocitajKcal)).perform(click())
        val sumaKCAL: ViewInteraction = onView(withId(R.id.sumaKalorii))
        val v = getText(sumaKCAL)

        assertEquals("130", v)
    }

    @Test fun noDataAdded() {
        onView(withId(R.id.vypocitajKcal)).perform(click())
        val sumaKCAL: ViewInteraction = onView(withId(R.id.sumaKalorii))

        assertEquals("Suma Kalorii", getText(sumaKCAL))


    }



    @Test
    fun checkMasoItems() {
        onView(withId(R.id.maso)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onView(withId(R.id.maso)).check(matches(withSpinnerText(containsString("kuracie"))));

        onView(withId(R.id.maso)).perform(click());
        onData(anything()).atPosition(2).perform(click());
        onView(withId(R.id.maso)).check(matches(withSpinnerText(containsString("hovadzie"))));

        onView(withId(R.id.maso)).perform(click());
        onData(anything()).atPosition(3).perform(click());
        onView(withId(R.id.maso)).check(matches(withSpinnerText(containsString("bravcove"))));

        onView(withId(R.id.maso)).perform(click());
        onData(anything()).atPosition(4).perform(click());
        onView(withId(R.id.maso)).check(matches(withSpinnerText(containsString("tofu"))));

        onView(withId(R.id.maso)).perform(click());
        onData(anything()).atPosition(5).perform(click());
        onView(withId(R.id.maso)).check(matches(withSpinnerText(containsString("sojove maso"))));
    }

    @Test
    public fun checPrilohaItems() {
        onView(withId(R.id.priloha)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onView(withId(R.id.priloha)).check(matches(withSpinnerText(containsString("ryza"))));

        onView(withId(R.id.priloha)).perform(click());
        onData(anything()).atPosition(2).perform(click());
        onView(withId(R.id.priloha)).check(matches(withSpinnerText(containsString("zemiaky"))));

        onView(withId(R.id.priloha)).perform(click());
        onData(anything()).atPosition(3).perform(click());
        onView(withId(R.id.priloha)).check(matches(withSpinnerText(containsString("bataty"))));

        onView(withId(R.id.priloha)).perform(click());
        onData(anything()).atPosition(4).perform(click());
        onView(withId(R.id.priloha)).check(matches(withSpinnerText(containsString("kuskus"))));

        onView(withId(R.id.priloha)).perform(click());
        onData(anything()).atPosition(5).perform(click());
        onView(withId(R.id.priloha)).check(matches(withSpinnerText(containsString("cestoviny"))));
    }

    @Test
    public fun checZeleninaItems() {
        onView(withId(R.id.zelenina)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onView(withId(R.id.zelenina)).check(matches(withSpinnerText(containsString("paprika"))));

        onView(withId(R.id.zelenina)).perform(click());
        onData(anything()).atPosition(2).perform(click());
        onView(withId(R.id.zelenina)).check(matches(withSpinnerText(containsString("paradajka"))));

        onView(withId(R.id.zelenina)).perform(click());
        onData(anything()).atPosition(3).perform(click());
        onView(withId(R.id.zelenina)).check(matches(withSpinnerText(containsString("uhorka"))));

        onView(withId(R.id.zelenina)).perform(click());
        onData(anything()).atPosition(4).perform(click());
        onView(withId(R.id.zelenina)).check(matches(withSpinnerText(containsString("salat"))));

        onView(withId(R.id.zelenina)).perform(click());
        onData(anything()).atPosition(5).perform(click());
        onView(withId(R.id.zelenina)).check(matches(withSpinnerText(containsString("mrkva"))));
    }

    @Test
    public fun checOvocieItems() {
        onView(withId(R.id.ovocie)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onView(withId(R.id.ovocie)).check(matches(withSpinnerText(containsString("jablko"))));

        onView(withId(R.id.ovocie)).perform(click());
        onData(anything()).atPosition(2).perform(click());
        onView(withId(R.id.ovocie)).check(matches(withSpinnerText(containsString("banan"))));

        onView(withId(R.id.ovocie)).perform(click());
        onData(anything()).atPosition(3).perform(click());
        onView(withId(R.id.ovocie)).check(matches(withSpinnerText(containsString("hruska"))));

        onView(withId(R.id.ovocie)).perform(click());
        onData(anything()).atPosition(4).perform(click());
        onView(withId(R.id.ovocie)).check(matches(withSpinnerText(containsString("hrozno"))));

        onView(withId(R.id.ovocie)).perform(click());
        onData(anything()).atPosition(5).perform(click());
        onView(withId(R.id.ovocie)).check(matches(withSpinnerText(containsString("kiwi"))));
    }

    /*@Rule
    @JvmField
    val mainActivityRule = IntentsTestRule(MainActivity::class.java)

    @Test fun backButton() {
        onView(withId(R.id.backButton)).perform(click())
        Intents.intended(IntentMatchers.hasComponent(MainActivity::class.java!!.getName()))


    }*/
}

