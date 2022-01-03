package com.example.submission3bajpdicoding.ui.tvShows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submission3bajpdicoding.data.source.ItemsRepository
import com.example.submission3bajpdicoding.data.source.local.entity.Items

class TvViewModel(private val itemsRepository: ItemsRepository): ViewModel() {
    fun getTVShows() : LiveData<List<Items>>{
        return itemsRepository.getAllTvShows()
    }

}