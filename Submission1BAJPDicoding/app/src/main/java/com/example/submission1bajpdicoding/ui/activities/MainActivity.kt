package com.example.submission1bajpdicoding.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.submission1bajpdicoding.R
import com.example.submission1bajpdicoding.databinding.ActivityMainBinding
import com.example.submission1bajpdicoding.utilities.PagerSectionAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val pagerSectionAdapter = PagerSectionAdapter(this, supportFragmentManager)
        main_toolbar.title = getString(R.string.app_name)
        main_viewPager.adapter = pagerSectionAdapter
        main_tabs.setupWithViewPager(main_viewPager)
    }
}