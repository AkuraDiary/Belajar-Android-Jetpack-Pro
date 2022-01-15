package com.example.submission3bajpdicoding.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.submission3bajpdicoding.R
import com.example.submission3bajpdicoding.ui.favorite.movie.FragmentMovieFavorite
import com.example.submission3bajpdicoding.ui.favorite.tvShow.FragmentTvFavorite

class FavoritePageAdapter(private val context: Context, fm : FragmentManager)
    : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        private val tabListFavoriteOf = intArrayOf(
            R.string.favorite_movie_text,
            R.string.favorite_tv_text
        )

    private val fragment : List<Fragment> = listOf(
        FragmentMovieFavorite(),
        FragmentTvFavorite()
    )

    override fun getPageTitle(position: Int): CharSequence {
        return context.getString(tabListFavoriteOf[position])
    }

    override fun getCount(): Int {
        return tabListFavoriteOf.size
    }

    override fun getItem(position: Int): Fragment {
        return fragment[position]
    }
}