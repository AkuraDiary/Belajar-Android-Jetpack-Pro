package com.example.submission1bajpdicoding.ui.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.lifecycle.ViewModelProvider
import com.example.submission1bajpdicoding.R
import com.example.submission1bajpdicoding.models.Items
import com.example.submission1bajpdicoding.ui.movies.FragmentMovie.Companion.EXTRA_CLICK_M
import com.example.submission1bajpdicoding.ui.movies.MovieViewModel
import com.example.submission1bajpdicoding.ui.tvShows.FragmentTV.Companion.EXTRA_CLICK_TV
import com.example.submission1bajpdicoding.ui.tvShows.TvViewModel
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    private lateinit var collapsingToolbarLayout: CollapsingToolbarLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        collapseToolbarConfiguration()

        val movieViewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
        val tvShowViewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory())[TvViewModel::class.java]

        when(intent.getIntExtra(CLICK_STATS, 0)){
            EXTRA_CLICK_M -> setBinding(movieViewModel.getDetailMovie(intent.getIntExtra(ID, 0))!!)
            EXTRA_CLICK_TV -> setBinding(tvShowViewModel.getDetailTV(intent.getIntExtra(ID, 0))!!)
        }
    }

    private fun setBinding(items: Items) {

    }

    private fun collapseToolbarConfiguration(){
        collapsingToolbarLayout = findViewById(R.id.collapsingToolbar)
        AppBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            if (collapsingToolbarLayout.height + verticalOffset < 2 * ViewCompat.getMinimumHeight(collapsingToolbarLayout)){
                collapsingToolbarLayout.setCollapsedTitleTextColor(Color.BLACK)
                detail_toolbar.apply {
                    setBackgroundColor(Color.WHITE)
                    title = intent.getStringExtra(JUDUL)
                    visibility = View.VISIBLE
                }
            } else {
                collapsingToolbarLayout.setExpandedTitleColor(Color.BLACK)
                detail_toolbar.setBackgroundColor(Color.TRANSPARENT)
                detail_toolbar.visibility = View.GONE
            }
        })
        detail_toolbar.setNavigationIcon(R.drawable.ic_back)
        detail_toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    companion object{
        const val ID = "id"
        const val CLICK_STATS = "click"
        const val JUDUL = "title"
    }
}