package com.decagon.registrationform

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{
    @Test
    fun test_isActivityInView() {
        //Launch main activity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        // Test if main in view
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun test_visibility_all_widget() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.tvTitle))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

        onView(withId(R.id.etName))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

        onView(withId(R.id.etPhoneNum))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

        onView(withId(R.id.etEmail))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

        onView(withId(R.id.spGender))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.btnRegister))

    }

    @Test
    fun test_allWidgetTextDisplayed() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.tvTitle))
            .check(matches(withText(R.string.app_name)))

        onView(withId(R.id.btnRegister))
            .check(matches(withText(R.string.btnRegister)))

        // for spinner and others
    }

    @Test
    fun test_navProfileActivity() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        // Click the button to navigate
//        onView(withId(R.id.btnRegister)).perform(click())
//        onView(withId(R.id.profile)).check(matches(isDisplayed()))

        onView(withId(R.id.etName)).perform(typeText("Adewumi Victor"), closeSoftKeyboard())
        onView(withId(R.id.etEmail)).perform(typeText("adevic4christ@gmail.com"), closeSoftKeyboard())
        onView(withId(R.id.etPhoneNum)).perform(typeText("07032333653"), closeSoftKeyboard())
//        onView(withId(R.id)).perform(typeText("Adewumi Victor"), closeSoftKeyboard())

    }

    @Test
    fun test_backPress_toMainActivity() {
        val activityScenario = ActivityScenario .launch(MainActivity::class.java)

        onView(withId(R.id.btnRegister)).perform(click())

        onView(withId(R.id.profile)).check(matches(isDisplayed()))

        pressBack()

        onView(withId(R.id.main)).check(matches(isDisplayed()))



//        onView(withId(R.id.btnRegister)).perform(click())
//
//        onView(withId(R.id.profile)).check(matches(isDisplayed()))
//
//        onView(withId(R.id.btnBack)).perform(click())
//
//        onView(withId(R.id.main)).check(matches(isDisplayed()))

    }
}