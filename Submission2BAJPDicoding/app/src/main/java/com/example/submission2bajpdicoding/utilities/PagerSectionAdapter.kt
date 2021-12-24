package com.example.submission2bajpdicoding.utilities

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.submission2bajpdicoding.R
import com.example.submission2bajpdicoding.ui.movies.FragmentMovie
import com.example.submission2bajpdicoding.ui.tvShows.FragmentTV

class PagerSectionAdapter(private val mContext:Context, fragmentManager : FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        @StringRes
        private val tabTitles = intArrayOf(R.string.text_movie, R.string.text_tv_show)

        override fun getItem(position: Int): Fragment {
            var fragment: Fragment? = null
            when(position){
                0 -> fragment = FragmentMovie()
                1 -> fragment = FragmentTV()
            }
            return fragment as Fragment
        }

        override fun getPageTitle(position: Int): CharSequence = mContext.resources.getString(tabTitles[position])

        override fun getCount(): Int = 2
}