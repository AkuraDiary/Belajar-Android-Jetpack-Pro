package com.example.submission3bajpdicoding

import android.content.pm.ActivityInfo
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.submission3bajpdicoding.ui.activities.MainActivity
import com.example.submission3bajpdicoding.utilities.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest{

    @get:Rule
    var activity = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp(){
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    private fun loadMovieAndTvData(){
        onView(withId(R.id.rv_movie_placeholder)).apply {
            check(matches(isDisplayed()))
            perform(swipeUp())
            perform(swipeDown())
            perform(swipeLeft())//geser
        }
        onView(withText("TV SHOWS")).perform(click()) //untuk memastikan bahwa tab tvshow telah dipilih

        onView(withId(R.id.rv_TV_placeholder)).apply {
            check(matches(isDisplayed()))
            perform(swipeUp())
            perform(swipeDown())
        }
    }

    private fun loadDetailMovie(){
        onView(withId(R.id.rv_movie_placeholder))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        swipeUp()

        onView(withId(R.id.cv_tv_title)).check(matches(isDisplayed()))

        onView(withId(R.id.cv_tv_release)).check(matches(isDisplayed()))

        onView(withId(R.id.cv_tv_originalTitle)).check(matches(isDisplayed()))

        onView(withId(R.id.cv_tv_popularity)).check(matches(isDisplayed()))

        onView(withId(R.id.cv_tv_score)).check(matches(isDisplayed()))

        swipeDown()

        onView(withId(R.id.poster_big_placeholder)).perform(pressBack())
    }

    private fun loadDetailTV(){
        onView(withId(R.id.rv_movie_placeholder)).perform(swipeLeft())
        onView(withId(R.id.rv_TV_placeholder))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        swipeUp()

        onView(withId(R.id.cv_tv_title)).check(matches(isDisplayed()))

        onView(withId(R.id.cv_tv_release)).check(matches(isDisplayed()))

        onView(withId(R.id.cv_tv_originalTitle)).check(matches(isDisplayed()))

        onView(withId(R.id.cv_tv_popularity)).check(matches(isDisplayed()))

        onView(withId(R.id.cv_tv_score)).check(matches(isDisplayed()))

        swipeDown()

        onView(withId(R.id.poster_big_placeholder)).perform(pressBack())
    }

    private fun tesRotasi(){

        activity.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        loadMovieAndTvData()
        onView(withId(R.id.rv_TV_placeholder)).apply {
            perform(swipeUp())
            perform(swipeRight())
        }
        loadDetailMovie()
        loadDetailTV()
        activity.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    private fun addMovieToFavorite(){
        onView(withId(R.id.rv_movie_placeholder))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.FavoriteButton)).check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.poster_big_placeholder)).perform(pressBack())
    }

    private fun removeMovieFromFavorite(){
        onView(withId(R.id.rv_movie_placeholder))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.FavoriteButton)).check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.poster_big_placeholder)).perform(pressBack())
    }

    private fun addTvToFavorite(){
        onView(withId(R.id.rv_movie_placeholder)).perform(swipeLeft())
        onView(withId(R.id.rv_TV_placeholder))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.FavoriteButton)).check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.poster_big_placeholder)).perform(pressBack())
    }

    private fun removeTvFromFavorite(){
        onView(withId(R.id.rv_movie_placeholder)).perform(swipeLeft())
        onView(withId(R.id.rv_TV_placeholder))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.FavoriteButton)).check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.poster_big_placeholder)).perform(pressBack())
    }

    @Test
    fun test1(){
        loadMovieAndTvData()
    }

    @Test
    fun test2(){
        loadDetailMovie()
    }

    @Test
    fun test3(){
        loadDetailTV()
    }

    @Test
    fun test4(){
        tesRotasi()
    }

    @Test
    fun test5(){

    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }
}