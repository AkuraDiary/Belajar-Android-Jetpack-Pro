package com.example.submission2bajpdicoding.ui.tvShows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submission2bajpdicoding.data.source.ItemsRepository
import com.example.submission2bajpdicoding.data.source.local.entity.Items
import com.example.submission2bajpdicoding.utilities.DataDummy

class TvViewModel(private val itemsRepository: ItemsRepository): ViewModel() {
    fun getTVShows() : LiveData<List<Items>>{
        return itemsRepository.getAllTvShows()
    }

    /*fun getDetailTV(id : Int): Items {
        return DataDummy.tvShowDetails(id)
    }*/

}