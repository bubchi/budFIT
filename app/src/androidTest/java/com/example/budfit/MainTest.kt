package com.example.budfit
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import com.example.budfit.MainActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.PositionAssertions.isRightOf
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Before
import java.util.regex.Pattern.matches

@RunWith(AndroidJUnit4::class)
@LargeTest
public class MainTest {


    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    /*private lateinit var scenario: ActivityScenario<MainActivity>
    @Before
    fun setup(){
        scenario = launchActivity()
        scenario.moveToState(Lifecycle.State.STARTED)
    }*/

    @Test
    public fun addWater() {
        //onView(with("Voda")).check(matches(isDisplayed()));

        onView(withId(R.id.vodaButton)).perform(click())
        //onView(withId(R.id.vodaText)).check(matches(withText("Hello Espresso!")))
        onView(withId(R.id.vodaButton)).check(isRightOf(withId(R.id.vodaText) ))

    }

    @Test
    public fun testOpenBMI() {
        //onView(with("Voda")).check(matches(isDisplayed()));
        onView(withId(R.id.button)).perform(click())


    }
}