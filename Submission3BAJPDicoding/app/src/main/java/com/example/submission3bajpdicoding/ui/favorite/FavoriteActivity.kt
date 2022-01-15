package com.example.submission3bajpdicoding.ui.favorite

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.submission3bajpdicoding.R
import com.example.submission3bajpdicoding.databinding.ActivityFavoriteBinding
import com.example.submission3bajpdicoding.ui.adapter.FavoritePageAdapter

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tabLayoutFavorite.setTabTextColors(Color.WHITE, Color.CYAN)
        supportActionBar?.title = getString(R.string.fav_txt)

        val viewPagerAdapter = FavoritePageAdapter(this, supportFragmentManager)
        binding.apply {
            favoriteViewPager.adapter = viewPagerAdapter
            tabLayoutFavorite.setupWithViewPager(favoriteViewPager)
        }
    }
}