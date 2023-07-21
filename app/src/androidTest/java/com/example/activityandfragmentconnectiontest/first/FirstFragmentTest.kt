package com.example.activityandfragmentconnectiontest.first

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith
import com.example.activityandfragmentconnectiontest.R



@RunWith(AndroidJUnit4ClassRunner::class)
class FirstFragmentTest {


    @Test
    fun test_isCounterVisible() {
        val scenario = launchFragmentInContainer<FirstFragment>()

        onView(withId(R.id.tv2)).check(matches(isDisplayed()))
    }
}