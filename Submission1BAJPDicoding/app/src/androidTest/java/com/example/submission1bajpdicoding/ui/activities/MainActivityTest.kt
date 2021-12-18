package com.example.submission1bajpdicoding.ui.activities

import android.os.SystemClock.sleep
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.submission1bajpdicoding.R
import com.example.submission1bajpdicoding.utilities.DataDummy
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test

class MainActivityTest{
    private val dataMovies = DataDummy.getMovie()
    private val dataTV = DataDummy.getTVShow()

    @get:Rule
    var activity = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loadMovieAndTvData(){
        onView(withId(R.id.rv_movie_placeholder)).apply {
            check(matches(isDisplayed()))
            perform(ViewActions.swipeUp())
            perform(ViewActions.swipeDown())
            perform(ViewActions.swipeLeft())//geser
        }

        onView(withId(R.id.rv_TV_placeholder)).apply {
            check(matches(isDisplayed()))
            perform(ViewActions.swipeUp())
            perform(ViewActions.swipeDown())
        }
    }

    @Test
    fun loadDetailMovie(){
        onView(withId(R.id.rv_movie_placeholder))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        //onView(withId(R.id.poster_big_placeholder)).perform(ViewActions.swipeUp())
        swipeUp()

        onView(withId(R.id.cv_tv_title)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dataMovies[0].judul)))
        }
        onView(withId(R.id.cv_tv_release)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dataMovies[0].waktuRelease)))
        }
        onView(withId(R.id.cv_tv_genre)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dataMovies[0].genre)))
        }
        onView(withId(R.id.cv_tv_duration)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dataMovies[0].durasi)))
        }
        onView(withId(R.id.cv_tv_score)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(dataMovies[0].score)))
        }

        //onView(allOf(withId(R.id.title_overview), withText("Sinopsis") )).perform(swipeDown())
        swipeDown()

        onView(withId(R.id.poster_big_placeholder)).perform(pressBack())
    }

}