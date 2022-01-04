package com.example.submission3bajpdicoding.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.data.source.remote.response.MovieItem
import com.example.submission3bajpdicoding.data.source.remote.response.MovieResponse
import com.example.submission3bajpdicoding.data.source.remote.response.TvShowItems
import com.example.submission3bajpdicoding.data.source.remote.response.TvShowResponse
import com.example.submission3bajpdicoding.networking.NetworkClient
import com.example.submission3bajpdicoding.utilities.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RemoteDataSource {

    fun getMovies(): LiveData<ApiResponse<List<MovieItem>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieItem>>>()
        NetworkClient.getApiService().getMovies().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val result = response.body()?.results
                if (result != null) {
                    resultMovie.postValue(ApiResponse.success(result))
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                EspressoIdlingResource.decrement()
            }
        })
        return resultMovie
    }

    fun getTvShow(): LiveData<ApiResponse<List<TvShowItem>>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShowItem>>>()
        NetworkClient.getApiService().getTvShow().enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                val result = response.body()?.results
                if (result != null) {
                    resultTvShow.postValue(ApiResponse.success(result))
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                EspressoIdlingResource.decrement()
            }
        })
        return resultTvShow
    }


    interface LoadMovieCallback{
        fun onAllMoviesReceived(movieItemResponse: List<MovieItem>?)
    }

    interface LoadTVCallback{
        fun onAllTvShowsReceived(tvItemResponse: List<TvShowItems>?)
    }
    companion object{
        private val TAG : String = RemoteDataSource::class.java.simpleName

        @Volatile
        private var instance : RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance ?: synchronized(this){
            instance ?: RemoteDataSource()
        }
    }
}