package com.example.submission2bajpdicoding.data.source.remote

import androidx.lifecycle.MutableLiveData
import com.example.submission2bajpdicoding.data.source.local.models.Items
import com.example.submission2bajpdicoding.networking.NetworkClient
import com.example.submission2bajpdicoding.utilities.EspressoIdlingResource


class RemoteDataSource {

    fun getMovies(callback : LoadMovieCallback){
        EspressoIdlingResource.increment()
        NetworkClient.getApiService()
    }

    companion object{
        private val TAB : String = RemoteDataSource::class.java.simpleName

        @Volatile
        private var instance : RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance ?: synchronized(this){
            instance ?: RemoteDataSource()
        }
    }

    interface LoadMovieCallback{
        fun onAllMoviesReceived(movieItemResponse: List<Items>?)
    }

    interface LoadTVCallback{
        fun onAllMoviesReceived(tvItemResponse: List<Items>?)
    }
}