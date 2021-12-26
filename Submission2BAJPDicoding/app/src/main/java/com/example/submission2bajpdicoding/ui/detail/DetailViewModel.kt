package com.example.submission2bajpdicoding.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submission2bajpdicoding.data.source.ItemsRepository
import com.example.submission2bajpdicoding.data.source.local.entity.Items

class DetailViewModel(private val itemsRepository: ItemsRepository) : ViewModel(){
    private lateinit var movieId : String
    private lateinit var tvId: String

    fun setSelectedMovie(movieID: String){
        this.movieId = movieID
    }

    fun setSelectedTV(tvShowId: String){
        this.tvId = tvShowId
    }

    fun getSelectedMovie():LiveData<Items> = itemsRepository.getMovieById(movieId)
    fun getSelectedTV(): LiveData<Items> = itemsRepository.getTvShowsById(tvId)
}