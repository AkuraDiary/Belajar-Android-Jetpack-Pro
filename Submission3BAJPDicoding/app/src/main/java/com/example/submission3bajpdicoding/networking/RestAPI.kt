package com.example.submission3bajpdicoding.networking

import com.example.submission3bajpdicoding.data.source.remote.response.MovieResponse
import com.example.submission3bajpdicoding.data.source.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.submission3bajpdicoding.BuildConfig

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
