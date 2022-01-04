package com.example.submission3bajpdicoding.data.source.local

import androidx.lifecycle.LiveData
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.data.source.local.room.ItemsDao
import androidx.paging.DataSource
import com.example.submission3bajpdicoding.utilities.SortUtils

class LocalDataSource(private val mItemsDao : ItemsDao) {
    fun getAllMovies(sort: String): DataSource.Factory<Int, Items>{
        val query = SortUtils.getSortedQueryMovies(sort)
        return mItemsDao.getAllMovies(query)
    }
    fun getAllfavoriteMovies(): DataSource.Factory<Int, Items>{
        return mItemsDao.getFavoriteMovies()
    }

    fun getAllTvShows(sort:String):DataSource.Factory<Int, Items>{
        val query = SortUtils.getSortedQueryTvShow(sort)
        return mItemsDao.getAllTvShows(query)
    }

    fun getAllFavoriteTvShow():DataSource.Factory<Int, Items>{
        return mItemsDao.getFavoriteTvShow()
    }

    fun setFavorite(item : Items, state:Boolean){
        item.isFavorite = state
        mItemsDao.updateItemData(item)
    }

    fun getMovie(movieId: Int): LiveData<Items> = mItemsDao.getMovieById(movieId)

    fun getTvShow(tvShowId: Int): LiveData<Items> = mItemsDao.getTvShowById(tvShowId)

    fun insertItems(movies: List<Items>) = mItemsDao.insertItemData(movies)

    fun updateItems(movie: Items) = mItemsDao.updateItemData(movie)
}