package com.example.submission3bajpdicoding.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submission3bajpdicoding.data.source.ItemsRepository
import com.example.submission3bajpdicoding.data.source.local.entity.Items

class MovieViewModel(private val itemsRepository: ItemsRepository) : ViewModel(){
    fun getMovies(): LiveData<List<Items>>{
        return itemsRepository.getAllMovies()
    }
}