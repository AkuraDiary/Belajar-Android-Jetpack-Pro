package com.example.submission3bajpdicoding.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.submission3bajpdicoding.data.source.ItemsRepository
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.vo.Resource

class MovieViewModel(private val itemsRepository: ItemsRepository) : ViewModel(){
    fun getMovies(sort:String): LiveData<Resource<PagedList<Items>>>{
        return itemsRepository.getAllMovies(sort)
    }
}