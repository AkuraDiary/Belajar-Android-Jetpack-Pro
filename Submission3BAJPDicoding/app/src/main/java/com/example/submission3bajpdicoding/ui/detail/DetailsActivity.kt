package com.example.submission3bajpdicoding.ui.detail

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.lifecycle.ViewModelProvider
import com.example.submission3bajpdicoding.R
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.databinding.ActivityDetailsBinding
import com.example.submission3bajpdicoding.ui.movies.FragmentMovie.Companion.EXTRA_CLICK_M
import com.example.submission3bajpdicoding.ui.tvShows.FragmentTV.Companion.EXTRA_CLICK_TV
import com.example.submission3bajpdicoding.utilities.DetailsDataBinding
import com.example.submission3bajpdicoding.utilities.GlideApp
import com.example.submission3bajpdicoding.utilities.ViewModelFactory
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout

class DetailsActivity : AppCompatActivity(), DetailsDataBinding {

    private lateinit var detailActivityViewBindng : ActivityDetailsBinding

    private lateinit var collapsingToolbarLayout: CollapsingToolbarLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailActivityViewBindng = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(detailActivityViewBindng.root)

        collapseToolbarConfiguration()

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        val id = intent.getIntExtra(ID, -1)

        when(intent.getIntExtra(CLICK_STATS, 0)){
            EXTRA_CLICK_M -> {
                viewModel.setSelectedMovie(id.toString())
                viewModel.getSelectedMovie(id.toString()).observe(this, {
                    setBinding(it)
                })
                detailActivityViewBindng.posterBigPlaceholder.visibility = View.VISIBLE
                detailActivityViewBindng.views2.visibility = View.VISIBLE
            }
            EXTRA_CLICK_TV -> {
                viewModel.setSelectedTV(id.toString())
                viewModel.getSelectedTV(id.toString()).observe(this, {
                    setBinding(it)
                })
                detailActivityViewBindng.posterBigPlaceholder.visibility = View.VISIBLE
                detailActivityViewBindng.views2.visibility = View.VISIBLE
            }
        }
    }

    override fun setBinding(items: Items) {
        multipleGlide(detailActivityViewBindng.posterBigPlaceholder, detailActivityViewBindng.posterSmallPlaceholder, items)
        detailActivityViewBindng.cvTvTitle.text = items.title
        detailActivityViewBindng.cvTvRelease.text = items.ReleaseDate.toString()
        detailActivityViewBindng.cvTvPopularity.text = items.popularity.toString()
        detailActivityViewBindng.cvTvOriginalTitle.text = items.score.toString()
        detailActivityViewBindng.cvTvScore.text = items.score.toString()
        detailActivityViewBindng.isiOverview.text = items.synopsis
    }

    override fun multipleGlide(firstImage: ImageView, secondImage: ImageView, items: Items) {
        GlideApp.with(this@DetailsActivity)
            .load(this@DetailsActivity.getString(R.string.baseUrl_Poster, items.poster))
            .into(firstImage)
        GlideApp.with(this@DetailsActivity)
            .load(this@DetailsActivity.getString(R.string.baseUrl_Poster, items.poster))
            .into(secondImage)
    }

    private fun collapseToolbarConfiguration(){
        collapsingToolbarLayout = findViewById(R.id.collapsingToolbar)

        detailActivityViewBindng.detailToolbar.setNavigationIcon(R.drawable.ic_back)
        detailActivityViewBindng.detailToolbar.setNavigationOnClickListener { onBackPressed() }

        detailActivityViewBindng.AppBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            if (collapsingToolbarLayout.height + verticalOffset < 2 * ViewCompat.getMinimumHeight(collapsingToolbarLayout)){
                collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE)
                detailActivityViewBindng.detailToolbar.apply {
                    visibility = View.VISIBLE
                    detailActivityViewBindng.cvTvTitle.visibility = View.GONE
                    setBackgroundColor(Color.TRANSPARENT)
                    title = intent.getStringExtra(JUDUL)
                }
            } else {
                detailActivityViewBindng.detailToolbar.visibility = View.GONE
                detailActivityViewBindng.cvTvTitle.visibility = View.VISIBLE
                collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT)
                detailActivityViewBindng.detailToolbar.setBackgroundColor(Color.TRANSPARENT)

            }
        })
    }

    companion object{
        const val ID = "id"
        const val CLICK_STATS = "click"
        const val JUDUL = "title"
    }
}