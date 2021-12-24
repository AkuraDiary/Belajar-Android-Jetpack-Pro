package com.example.submission2bajpdicoding.ui.movies

import androidx.lifecycle.ViewModel
import com.example.submission2bajpdicoding.models.Items
import com.example.submission2bajpdicoding.utilities.DataDummy

class MovieViewModel : ViewModel(){
    fun getMovies():List<Items>{
        return DataDummy.getMovie()
    }

    fun getDetailMovie(id: Int) : Items?{
        return DataDummy.movieDetails(id)
    }
}