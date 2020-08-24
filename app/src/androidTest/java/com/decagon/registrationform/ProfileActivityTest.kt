package com.decagon.registrationform

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class ProfileActivityTest{
    // Setting up a test rule
    @get: Rule
    val activityRule = ActivityScenarioRule(ProfileActivity::class.java)

    @Test
    fun test_isActivityInView() {
        onView(withId(R.id.profile))
            .check(matches(isDisplayed()))
    }
}