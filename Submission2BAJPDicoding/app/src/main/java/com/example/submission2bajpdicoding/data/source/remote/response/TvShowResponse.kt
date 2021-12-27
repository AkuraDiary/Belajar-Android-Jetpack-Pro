package com.example.submission2bajpdicoding.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvShowResponse (
    @field:SerializedName("results")
    val results: List<TvShowItems>

    )
data class TvShowItems(
    @field:SerializedName("first_air_date")
    val firstAirDate: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("vote_average")
    val voteAverage: Double,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("original_title")
    val originalTitle: String,

    @field:SerializedName("popularity")
    val popularity: Double,
)


