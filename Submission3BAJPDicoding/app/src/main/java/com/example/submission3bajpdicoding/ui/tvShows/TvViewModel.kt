package com.example.submission3bajpdicoding.ui.tvShows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.submission3bajpdicoding.data.source.ItemsRepository
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.vo.Resource

class TvViewModel(private val itemsRepository: ItemsRepository): ViewModel() {
    fun getTVShows(sort : String) : LiveData<Resource<PagedList<Items>>> {
        return itemsRepository.getAllTvShows(sort)
    }
}