package com.example.submission3bajpdicoding.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import androidx.paging.DataSource

@Dao
interface ItemsDao {

    @RawQuery(observedEntities = [Items::class])
    fun getAllMovies(query: SupportSQLiteQuery): DataSource.Factory<Int, Items>

    @RawQuery(observedEntities = [Items::class])
    fun getAllTvShows(query: SupportSQLiteQuery): DataSource.Factory<Int, Items>

    @Transaction
    @Query("SELECT * FROM tabel_items WHERE id = :movieId")
    fun getMovieById(movieId: Int): LiveData<Items>

    @Transaction
    @Query("SELECT * FROM tabel_items WHERE id = :tvShowId")
    fun getTvShowById(tvShowId: Int): LiveData<Items>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItemData(movies: List<Items>)

    @Update
    fun updateItemData(movies: Items)

    @Query("SELECT * FROM tabel_items WHERE isFavorite = 1 AND isTvShow = 0")
    fun getFavoriteMovies(): DataSource.Factory<Int, Items>

    @Query("SELECT * FROM tabel_items WHERE isFavorite = 1 AND isTvShow = 1")
    fun getFavoriteTvShow(): DataSource.Factory<Int, Items>


}