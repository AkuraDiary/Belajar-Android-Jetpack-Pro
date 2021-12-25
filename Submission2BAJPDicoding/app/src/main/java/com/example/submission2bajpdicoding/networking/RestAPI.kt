package com.example.submission2bajpdicoding.networking

import com.example.submission2bajpdicoding.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestAPI {

    @GET("movie")
    fun getMovies(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ) : Call<MovieResponse>

    @GET("tv")
    fun getTVShow(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ) : Call<TvShowResponse>

}
