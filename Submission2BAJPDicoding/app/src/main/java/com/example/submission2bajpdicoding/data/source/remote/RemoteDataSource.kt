package com.example.submission2bajpdicoding.data.source.remote

import android.util.Log
import com.example.submission2bajpdicoding.data.source.remote.response.MovieItem
import com.example.submission2bajpdicoding.data.source.remote.response.MovieResponse
import com.example.submission2bajpdicoding.data.source.remote.response.TvShowItems
import com.example.submission2bajpdicoding.data.source.remote.response.TvShowResponse
import com.example.submission2bajpdicoding.networking.NetworkClient
import com.example.submission2bajpdicoding.utilities.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RemoteDataSource {

    fun getMovies(callback : LoadMovieCallback){
        EspressoIdlingResource.increment()
        NetworkClient.getApiService().getMovies().enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                callback.onAllMoviesReceived(response.body()?.results)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getTvShow(callback: LoadTVCallback){
        EspressoIdlingResource.increment()
        NetworkClient.getApiService().getTVShow().enqueue(object  : Callback<TvShowResponse>{
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                callback.onAllTvShowsReceived(response.body()?.results)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    companion object{
        private val TAG : String = RemoteDataSource::class.java.simpleName

        @Volatile
        private var instance : RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance ?: synchronized(this){
            instance ?: RemoteDataSource()
        }
    }

    interface LoadMovieCallback{
        fun onAllMoviesReceived(movieItemResponse: List<MovieItem>?)
    }

    interface LoadTVCallback{
        fun onAllTvShowsReceived(tvItemResponse: List<TvShowItems>?)
    }
}