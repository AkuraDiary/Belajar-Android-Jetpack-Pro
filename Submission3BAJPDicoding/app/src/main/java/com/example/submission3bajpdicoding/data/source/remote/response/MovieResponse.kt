package com.example.submission3bajpdicoding.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse (

    @field:SerializedName("page")
    val page : Int,

    @field:SerializedName("total_pages")
    val totalPages: Int,

    @field:SerializedName("results")
    val results: List<MovieItem>,

    @field:SerializedName("total_results")
    val totalResults: Int

)

data class MovieItem(
    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("release_date")
    val releaseDate: String,

    @field:SerializedName("vote_average")
    val voteAverage: Double, //score

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("original_title")
    val originalTitle: String,

    @field:SerializedName("popularity")
    val popularity: Double,
)