package com.example.submission3bajpdicoding.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.submission3bajpdicoding.data.source.ItemsRepository
import com.example.submission3bajpdicoding.data.source.local.entity.Items

class FavoriteViewModel(private val movieRepository: ItemsRepository) : ViewModel() {

    fun getFavoriteMovies(): LiveData<PagedList<Items>> =
        movieRepository.getFavoriteMovies()

    fun getFavoriteTvShows(): LiveData<PagedList<Items>> =
        movieRepository.getFavoriteTvShow()

    fun setFavoriteData(items: Items) {
        val newState = !items.isFavorite
        movieRepository.setToFavorite(items, newState)
    }
}
