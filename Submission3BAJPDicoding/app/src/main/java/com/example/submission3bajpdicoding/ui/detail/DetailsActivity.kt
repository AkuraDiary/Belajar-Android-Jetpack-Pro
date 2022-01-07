package com.example.submission3bajpdicoding.ui.detail

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.example.submission3bajpdicoding.R
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.databinding.ActivityDetailsBinding
import com.example.submission3bajpdicoding.utilities.DetailsDataBinding
import com.example.submission3bajpdicoding.utilities.GlideApp
import com.example.submission3bajpdicoding.vo.Resource
import com.example.submission3bajpdicoding.vo.Status
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsActivity : AppCompatActivity(), DetailsDataBinding {

    private lateinit var detailActivityViewBindng : ActivityDetailsBinding
    private val viewModel: DetailViewModel by viewModel()
    private lateinit var collapsingToolbarLayout: CollapsingToolbarLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailActivityViewBindng = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(detailActivityViewBindng.root)

        collapseToolbarConfiguration()

        //val factory = ViewModelFactory.getInstance()
        //val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        val type = intent.getIntExtra(CLICK_STATS, -1)
        val id = intent.getIntExtra(ID, -1)
        val typeEnum : DetailType = DetailType.values()[type]

        when(typeEnum){
            DetailType.MOVIE -> {
                viewModel.setSelectedMovie(id)
                viewModel.movieDetail.observe(this, {movie ->
                    if (movie != null){
                        showDetailData(movie)
                    }
                })
            }
            DetailType.TV_SHOW -> {
                viewModel.setSelectedTV(id)
                viewModel.tvDetail.observe(this, {tv ->
                    if(tv != null){
                        showDetailData(tv)
                    }
                })
            }
        }

        detailActivityViewBindng.FavoriteButton.setOnClickListener{
            when(typeEnum){
                DetailType.MOVIE -> {
                    viewModel.setFavoriteMovie()
                }

                DetailType.TV_SHOW -> {
                    viewModel.setFavoriteTv()
                }
            }
        }
    }

    override fun setBinding(items: Items) {
        multipleGlide(detailActivityViewBindng.posterBigPlaceholder, detailActivityViewBindng.posterSmallPlaceholder, items)
        detailActivityViewBindng.apply {
            cvTvTitle.text = items.title
            cvTvRelease.text = items.ReleaseDate.toString()
            cvTvPopularity.text = items.popularity.toString()
            cvTvOriginalTitle.text = items.score.toString()
            cvTvScore.text = items.score.toString()
            isiOverview.text = items.synopsis
        }

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

    private fun showDetailData(item : Resource<Items>){
        when(item.status){
            Status.LOADING -> detailActivityViewBindng.progressBar.visibility = View.VISIBLE
            Status.SUCCESS -> if (item.data != null){
                detailActivityViewBindng.progressBar.visibility = View.GONE
                val state = item.data.isFavorite
                setFavorite(state)
                setBinding(item.data)
            }
            Status.ERROR -> {
                detailActivityViewBindng.progressBar.visibility = View.GONE
                Toast.makeText(this, "There is an Error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setFavorite(state : Boolean){
        if (state){
            detailActivityViewBindng.FavoriteButton.setImageDrawable(
                ContextCompat.getDrawable(
                    this, R.drawable.ic_favorite
                )
            )
        }else{
            detailActivityViewBindng.FavoriteButton.setImageDrawable(
                ContextCompat.getDrawable(
                    this, R.drawable.ic_unfavorite
                )
            )
        }
    }

}