package com.example.tamagotchi

import android.view.View
import android.widget.ImageView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivity2Test {

    @Before
    fun setUp() {
        // Start the MainActivity2 before each test
        ActivityScenario.launch(MainActivity2::class.java)
    }

    @Test
    fun testFeedButton() {
        onView(withId(R.id.feedButton)).perform(click())
        onView(withId(R.id.imageView2)).check(matches(withDrawable(R.drawable.mame5)))
        onView(withId(R.id.textView5)).check(matches(withText("80%")))
    }

    @Test
    fun testCleanButton() {
        onView(withId(R.id.cleanButton)).perform(click())
        onView(withId(R.id.imageView2)).check(matches(withDrawable(R.drawable.mame3)))
        onView(withId(R.id.textView6)).check(matches(withText("50%")))
    }

    @Test
    fun testPlayButton() {
        onView(withId(R.id.playButton)).perform(click())
        onView(withId(R.id.imageView2)).check(matches(withDrawable(R.drawable.mame4)))
        onView(withId(R.id.textView7)).check(matches(withText("75%")))
    }

    // Custom matcher to check if ImageView displays the correct drawable
    private fun withDrawable(resourceId: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description?) {
                description?.appendText("with drawable resource id: $resourceId")
            }

            override fun matchesSafely(item: View?): Boolean {
                if (item !is ImageView) return false
                val resources = InstrumentationRegistry.getInstrumentation().targetContext.resources
                val expectedDrawable = resources.getDrawable(resourceId, null)
                val actualDrawable = item.drawable
                return expectedDrawable.constantState == actualDrawable.constantState
            }
        }
    }
}
