package com.decagon.registrationform

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
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

    @Test
    fun test_visibility_all_widget(){
        onView(withId(R.id.tvWelcome))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvName))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvEmail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvPhone))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvGender))
            .check(matches(isDisplayed()))

        onView(withId(R.id.btnBack))
            .check(matches(isDisplayed()))
    }
    @Test
    fun test_all_Widget_Text_Display() {
        val activityScenario = ActivityScenario.launch(ProfileActivity::class.java)

        onView(withId(R.id.tvSuccess))
            .check(matches(ViewMatchers.withText(R.string.registration_successful)))

        onView(withId(R.id.tvWelcome))
            .check(matches(ViewMatchers.withText(R.string.welcome)))

        onView(withId(R.id.tvEmail))
            .check(matches(ViewMatchers.withText(R.string.email)))

        onView(withId(R.id.tvPhone))
            .check(matches(ViewMatchers.withText(R.string.phone_no)))

        onView(withId(R.id.tvGender))
            .check(matches(ViewMatchers.withText(R.string.gender)))

        onView(withId(R.id.tvName))
            .check(matches(ViewMatchers.withText(R.string.full_name)))

        onView(withId(R.id.btnBack))
            .check(matches(ViewMatchers.withText(R.string.close)))

    }
}