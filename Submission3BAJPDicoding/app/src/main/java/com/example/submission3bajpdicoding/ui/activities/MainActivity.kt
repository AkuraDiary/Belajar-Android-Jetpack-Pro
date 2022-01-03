package com.example.submission3bajpdicoding.ui.activities

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.submission3bajpdicoding.R
import com.example.submission3bajpdicoding.databinding.ActivityMainBinding
import com.example.submission3bajpdicoding.utilities.PagerSectionAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(activityMainBinding.root)
        supportActionBar?.hide()
        val pagerSectionAdapter = PagerSectionAdapter(this, supportFragmentManager)
        activityMainBinding.mainToolbar.title = getString(R.string.app_name)

        activityMainBinding.mainViewPager.adapter = pagerSectionAdapter

        activityMainBinding.mainToolbar.setTitleTextColor(Color.WHITE)
        activityMainBinding.mainTabs.setTabTextColors(Color.WHITE, Color.CYAN)
        activityMainBinding.mainTabs.setupWithViewPager(activityMainBinding.mainViewPager)
    }
} 