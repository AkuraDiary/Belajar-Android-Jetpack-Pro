package com.example.submission1bajpdicoding.ui.activities

import androidx.test.rule.ActivityTestRule
import com.example.submission1bajpdicoding.utilities.DataDummy
import org.junit.Rule

class MainActivityTest{
    private val dataMovies = DataDummy.getMovie()
    private val dataTV = DataDummy.getTVShow()

    @get:Rule
    var activity = ActivityTestRule(MainActivity::class.java)


}