package com.example.submission2bajpdicoding.ui.activities

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.submission2bajpdicoding.R
import com.example.submission2bajpdicoding.utilities.PagerSectionAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val pagerSectionAdapter = PagerSectionAdapter(this, supportFragmentManager)
        main_toolbar.title = getString(R.string.app_name)

        main_toolbar.setTitleTextColor(Color.WHITE)
        main_tabs.setTabTextColors(Color.WHITE, Color.CYAN)
        main_viewPager.adapter = pagerSectionAdapter

        main_tabs.setupWithViewPager(main_viewPager)
    }
} 