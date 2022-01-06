package com.example.submission3bajpdicoding.ui.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.example.submission3bajpdicoding.R
import com.example.submission3bajpdicoding.databinding.ActivityMainBinding
import com.example.submission3bajpdicoding.ui.favorite.FavoriteActivity
import com.example.submission3bajpdicoding.utilities.PagerSectionAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val viewPagerAdapter = HomeViewPagerAdapter(this, supportFragmentManager)

        activityMainBinding.mainToolbar.setTitleTextColor(Color.WHITE)
        activityMainBinding.mainTabs.setTabTextColors(Color.WHITE, Color.CYAN)

        setContentView(activityMainBinding.root)
        supportActionBar?.hide()

        activityMainBinding.mainViewPager.adapter = viewPagerAdapter
        activityMainBinding.mainTabs.setupWithViewPager(activityMainBinding.mainViewPager)

        activityMainBinding.ivFavoriteMain.setOnClickListener {
            val intent = Intent(this, FavoriteActivity::class.java)
            startActivity(intent)
        }

        /*val pagerSectionAdapter = PagerSectionAdapter(this, supportFragmentManager)
        activityMainBinding.mainToolbar.title = getString(R.string.app_name)

        activityMainBinding.mainViewPager.adapter = pagerSectionAdapter

        activityMainBinding.mainToolbar.setTitleTextColor(Color.WHITE)
        activityMainBinding.mainTabs.setTabTextColors(Color.WHITE, Color.CYAN)
        activityMainBinding.mainTabs.setupWithViewPager(activityMainBinding.mainViewPager)*/
    }
} 