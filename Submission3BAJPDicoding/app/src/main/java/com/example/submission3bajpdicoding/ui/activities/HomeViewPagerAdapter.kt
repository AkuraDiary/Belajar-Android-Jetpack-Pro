package com.example.submission3bajpdicoding.ui.activities

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.submission3bajpdicoding.R
import com.example.submission3bajpdicoding.ui.movies.FragmentMovie
import com.example.submission3bajpdicoding.ui.tvShows.FragmentTV

class HomeViewPagerAdapter (private val context : Context, fragmentManager: FragmentManager)
    : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val tabListOf = intArrayOf(
        R.string.text_movie,
        R.string.text_tv_show
    )
    private val fragment : List<Fragment> = listOf(
        FragmentMovie(),
        FragmentTV()

    )

    override fun getPageTitle(position: Int): CharSequence {
        return context.getString(tabListOf[position])
    }

    override fun getCount(): Int {
        return tabListOf.size
    }
    override fun getItem(position: Int): Fragment {
        return fragment[position]
    }

}