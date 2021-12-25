package com.example.submission2bajpdicoding

import android.content.pm.ActivityInfo
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.submission2bajpdicoding.ui.activities.MainActivity
import com.example.submission2bajpdicoding.utilities.DataDummy
import org.junit.Rule
import org.junit.Test

class MainActivityTest{
    private val dataMovies = DataDummy.getMovie()
    private val dataTV = DataDummy.getTVShow()

    @get:Rule
    var activity = ActivityTestRule(MainActivity::class.java)

    private fun loadMovieAndTvData(){
        onView(withId(R.id.rv_movie_placeholder)).apply {
            check(matches(isDisplayed()))
            perform(swipeUp())
            perform(swipeDown())
            perform(swipeLeft())//geser
        }

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

        onView(withId(R.id.cv_tv_title)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dataMovies[0].judul)))
        }
        onView(withId(R.id.cv_tv_release)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dataMovies[0].waktuRelease)))
        }
        onView(withId(R.id.cv_tv_originalTitle)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dataMovies[0].OriginalTitle)))
        }
        onView(withId(R.id.cv_tv_duration)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dataMovies[0].popularity)))
        }
        onView(withId(R.id.cv_tv_score)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dataMovies[0].score)))
        }

        swipeDown()

        onView(withId(R.id.poster_big_placeholder)).perform(pressBack())
    }

    private fun loadDetailTV(){
        onView(withId(R.id.rv_movie_placeholder)).perform(swipeLeft())
        onView(withId(R.id.rv_TV_placeholder))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        swipeUp()

        onView(withId(R.id.cv_tv_title)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dataTV[0].judul)))
        }
        onView(withId(R.id.cv_tv_release)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dataTV[0].waktuRelease)))
        }
        onView(withId(R.id.cv_tv_originalTitle)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dataTV[0].OriginalTitle)))
        }
        onView(withId(R.id.cv_tv_duration)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dataTV[0].popularity)))
        }
        onView(withId(R.id.cv_tv_score)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dataTV[0].score)))
        }

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
}