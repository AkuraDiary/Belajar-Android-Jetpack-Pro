package com.example.submission3bajpdicoding.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submission3bajpdicoding.data.source.ItemsRepository
import com.example.submission3bajpdicoding.data.source.local.entity.Items

class DetailViewModel(private val itemsRepository: ItemsRepository) : ViewModel(){
    private lateinit var movieId : String
    private lateinit var tvId: String

    fun setSelectedMovie(movieID: String){
        this.movieId = movieID
    }

    fun setSelectedTV(tvShowId: String){
        this.tvId = tvShowId
    }

    fun getSelectedMovie(ID: String):LiveData<Items> = itemsRepository.getMovieById(ID)
    fun getSelectedTV(ID : String): LiveData<Items> = itemsRepository.getTvShowsById(ID)
}