package com.muhammetcagatay.guestlist.ui.event


import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.muhammetcagatay.guestlist.R
import kotlinx.android.synthetic.main.activity_event_list.view.*
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.rule.ActivityTestRule

/**
 * Created by Muhammet ÇAĞATAY on 17,Şubat,2020
 */

@RunWith(AndroidJUnit4::class)
@LargeTest
class EventListActivityTest  {

    @get:Rule
    var mActivityTestRule = ActivityTestRule(EventListActivity::class.java)
    private var mIdlingResource: IdlingResource? = null


    @Test
    fun testScroll() {
        Espresso.onView(ViewMatchers.withId(R.id.rv_event_list)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        Espresso.onView(ViewMatchers.withId(R.id.txt_event_name)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.txt_date)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


    @Test
    fun displayNewsData() {
        Espresso.onView(ViewMatchers.withId(R.id.rv_event_list)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


    @After
    fun unregisterIdlingResource() {
        if (mIdlingResource != null) {
            IdlingRegistry.getInstance().unregister()
        }
    }
}