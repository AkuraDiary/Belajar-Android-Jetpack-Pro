package com.example.submission2bajpdicoding.ui.detail

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.submission2bajpdicoding.R
import com.example.submission2bajpdicoding.databinding.ActivityDetailsBinding
import com.example.submission2bajpdicoding.data.source.local.entity.Items
import com.example.submission2bajpdicoding.ui.movies.FragmentMovie.Companion.EXTRA_CLICK_M
import com.example.submission2bajpdicoding.ui.movies.MovieViewModel
import com.example.submission2bajpdicoding.ui.tvShows.FragmentTV.Companion.EXTRA_CLICK_TV
import com.example.submission2bajpdicoding.ui.tvShows.TvViewModel
import com.example.submission2bajpdicoding.utilities.DetailsDataBinding
import com.example.submission2bajpdicoding.utilities.ViewModelFactory
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

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        /*val movieViewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
        val tvShowViewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory())[TvViewModel::class.java]*/

        when(intent.getIntExtra(CLICK_STATS, 0)){
            EXTRA_CLICK_M -> {
                viewModel.setSelectedMovie(ID)
                setBinding(viewModel.getSelectedMovie(ID))
            }
            EXTRA_CLICK_TV -> {
                viewModel.setSelectedTV(ID)
                setBinding(viewModel.getSelectedTV(ID))
            }
        }
    }

    override fun setBinding(items: LiveData<Items>) {
        multipleGlide(detailActivityViewBindng.posterBigPlaceholder, detailActivityViewBindng.posterSmallPlaceholder, items)
        detailActivityViewBindng.cvTvTitle.text = items.value?.title
        detailActivityViewBindng.cvTvRelease.text = items.value?.score.toString()
        detailActivityViewBindng.cvTvPopularity.text = items.value?.popularity.toString()
        detailActivityViewBindng.cvTvOriginalTitle.text = items.value?.score.toString()
        detailActivityViewBindng.cvTvScore.text = items.value?.score.toString()
        detailActivityViewBindng.isiOverview.text = items.value?.synopsis
    }

    override fun multipleGlide(firstImage: ImageView, secondImage: ImageView, items: LiveData<Items>) {
        Glide.with(this@DetailsActivity)
            .load(this@DetailsActivity.getString(R.string.baseUrl_Poster, items.value?.poster))
            .into(firstImage)
        Glide.with(this@DetailsActivity)
            .load(this@DetailsActivity.getString(R.string.baseUrl_Poster, items.value?.poster))
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
                    setBackgroundColor(Color.TRANSPARENT)
                    title = intent.getStringExtra(JUDUL)
                    visibility = View.VISIBLE
                    detailActivityViewBindng.cvTvTitle.visibility = View.GONE
                }
            } else {
                collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT)
                detailActivityViewBindng.detailToolbar.setBackgroundColor(Color.TRANSPARENT)
                detailActivityViewBindng.detailToolbar.visibility = View.GONE
                detailActivityViewBindng.cvTvTitle.visibility = View.VISIBLE
            }
        })
    }

    companion object{
        const val ID = "id"
        const val CLICK_STATS = "click"
        const val JUDUL = "title"
    }
}