package com.example.submission3bajpdicoding.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.submission3bajpdicoding.data.source.ItemsRepository
import com.example.submission3bajpdicoding.data.source.local.entity.Items

class FavoriteViewModel(private val itemsRepository: ItemsRepository) : ViewModel() {

    fun getFavoriteMovies(): LiveData<PagedList<Items>> =
        itemsRepository.getFavoriteMovies()

    fun getFavoriteTvShows(): LiveData<PagedList<Items>> =
        itemsRepository.getFavoriteTvShow()

    fun setFavoriteData(items: Items) {
        val newState = !items.isFavorite
        itemsRepository.setToFavorite(items, newState)
    }
}
