package com.example.submission3bajpdicoding.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.submission3bajpdicoding.data.source.local.LocalDataSource
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.data.source.remote.ApiResponse
import com.example.submission3bajpdicoding.data.source.remote.NetworkBoundResource
import com.example.submission3bajpdicoding.data.source.remote.RemoteDataSource
import com.example.submission3bajpdicoding.data.source.remote.response.MovieItem
import com.example.submission3bajpdicoding.data.source.remote.response.TvShowItems
import com.example.submission3bajpdicoding.utilities.AppExecutors
import com.example.submission3bajpdicoding.vo.Resource

class ItemsRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): ItemsDataSource{

    override fun getAllMovies(sort:String): LiveData<Resource<PagedList<Items>>> {
        return object :
            NetworkBoundResource<PagedList<Items>, List<MovieItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<Items>> {
                val config =PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(sort), config).build()
            }

            override fun shouldFetch(data: PagedList<Items>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<MovieItem>>> {
                return remoteDataSource.getMovies()
            }

            override fun saveCallResult(data: List<MovieItem>) {
                val movieList = ArrayList<Items>()
                for(response in data){
                    val movie = Items(
                        response.id,
                        response.title,
                        response.releaseDate,
                        response.originalTitle,
                        response.popularity,
                        response.voteAverage,
                        response.overview,
                        response.posterPath,
                        isFavorite = false,
                        isTvShow = false
                    )
                    movieList.add(movie)
                }
                localDataSource.insertItems(movieList)
            }
        }.asLiveData()
    }


    override fun getMovieById(Id: Int): LiveData<Resource<Items>> {
        return object :
        NetworkBoundResource<Items, List<MovieItem>>(appExecutors){
            override fun loadFromDB(): LiveData<Items> {
                return localDataSource.getMovie(Id)
            }

            override fun shouldFetch(data: Items?): Boolean {
                return data == null
            }

            override fun createCall(): LiveData<ApiResponse<List<MovieItem>>> {
                return remoteDataSource.getMovies()
            }
            override fun saveCallResult(data: List<MovieItem>) {
                lateinit var movieItem: Items
                for (movie in data){
                    if (Id == movie.id){
                        movieItem = Items(
                            movie.id,
                            movie.title,
                            movie.releaseDate,
                            movie.originalTitle,
                            movie.popularity,
                            movie.voteAverage,
                            movie.overview,
                            movie.posterPath,
                            isFavorite = false,
                            isTvShow = false
                        )
                    }
                }
                localDataSource.updateItems(movieItem)
            }
        }.asLiveData()
    }

    override fun getAllTvShows(sort : String): LiveData<Resource<PagedList<Items>>> {
        return object :
        NetworkBoundResource<PagedList<Items>, List<TvShowItems>>(appExecutors){
            override fun loadFromDB(): LiveData<PagedList<Items>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShows(sort), config).build()
            }

            override fun shouldFetch(data: PagedList<Items>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<TvShowItems>>> {
                return remoteDataSource.getTvShow()
            }

            override fun saveCallResult(data: List<TvShowItems>) {
                val tvList = ArrayList<Items>()
                for(response in data){
                    val tv = Items(
                        response.id,
                        response.name,
                        response.firstAirDate,
                        response.originalTitle,
                        response.popularity,
                        response.voteAverage,
                        response.overview,
                        response.posterPath,
                        isFavorite = false,
                        isTvShow = true
                    )
                    tvList.add(tv)
                }
                localDataSource.insertItems(tvList)
            }
        }.asLiveData()
    }

    override fun getTvShowsById(Id: Int): LiveData<Resource<Items>> {
        return object :
        NetworkBoundResource<Items, List<TvShowItems>>(appExecutors){
            override fun loadFromDB(): LiveData<Items> {
                return localDataSource.getTvShow(Id)
            }

            override fun shouldFetch(data: Items?): Boolean {
                return data ==null
            }

            override fun createCall(): LiveData<ApiResponse<List<TvShowItems>>> {
                return remoteDataSource.getTvShow()
            }

            override fun saveCallResult(data: List<TvShowItems>) {
                lateinit var item : Items
                for(tv in data){
                    if(Id == tv.id){
                        item = Items(
                            tv.id,
                            tv.name,
                            tv.firstAirDate,
                            tv.originalTitle,
                            tv.popularity,
                            tv.voteAverage,
                            tv.overview,
                            tv.posterPath,
                            isFavorite = false,
                            isTvShow = true
                        )
                    }
                }
                localDataSource.updateItems(item)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<PagedList<Items>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getAllfavoriteMovies(), config).build()
    }

    override fun getFavoriteTvShow(): LiveData<PagedList<Items>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getAllFavoriteTvShow(), config).build()
    }

    override fun setToFavorite(item: Items, state: Boolean) {
        return appExecutors.diskIO().execute{
            localDataSource.setFavorite(item, state)
        }
    }

}