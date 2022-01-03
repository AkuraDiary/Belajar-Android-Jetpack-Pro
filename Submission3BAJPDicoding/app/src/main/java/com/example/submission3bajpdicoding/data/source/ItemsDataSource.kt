package com.example.submission3bajpdicoding.data.source

import androidx.lifecycle.LiveData
import com.example.submission3bajpdicoding.data.source.local.entity.Items

interface ItemsDataSource {
    fun getAllMovies(): LiveData<List<Items>>

    fun getMovieById(Id : String) : LiveData<Items>

    fun getAllTvShows(): LiveData<List<Items>>

    fun getTvShowsById(Id : String) : LiveData<Items>
}