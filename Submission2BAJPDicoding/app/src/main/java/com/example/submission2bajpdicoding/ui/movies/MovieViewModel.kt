package com.example.submission2bajpdicoding.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submission2bajpdicoding.data.source.ItemsRepository
import com.example.submission2bajpdicoding.data.source.local.entity.Items
import com.example.submission2bajpdicoding.utilities.DataDummy

class MovieViewModel(private val itemsRepository: ItemsRepository) : ViewModel(){
    fun getMovies(): LiveData<List<Items>>{
        return itemsRepository.getAllMovies()
    }
/*fun getMovies():List<Items>{
        return DataDummy.getMovie()
    }*/

    /*fun getDetailMovie(id: Int) : Items {
        return DataDummy.movieDetails(id)
    }*/
}