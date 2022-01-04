package com.example.submission3bajpdicoding.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.vo.Resource

interface ItemsDataSource {
    fun getAllMovies(sort:String): LiveData<Resource<PagedList<Items>>>

    fun getMovieById(Id : Int) : LiveData<Resource<Items>>

    fun getAllTvShows(sort: String): LiveData<Resource<PagedList<Items>>>

    fun getTvShowsById(Id : Int) : LiveData<Resource<Items>>

    fun getFavoriteMovies(): LiveData<PagedList<Items>>

    fun getFavoriteTvShow(): LiveData<PagedList<Items>>

    fun setToFavorite(item: Items, state: Boolean)
}