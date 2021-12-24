package com.example.submission1bajpdicoding.ui.movies

import androidx.lifecycle.ViewModel
import com.example.submission1bajpdicoding.models.Items
import com.example.submission1bajpdicoding.utilities.DataDummy

class MovieViewModel : ViewModel(){
    fun getMovies():List<Items>{
        return DataDummy.getMovie()
    }

    fun getDetailMovie(id: Int) : Items?{
        return DataDummy.movieDetails(id)
    }
}