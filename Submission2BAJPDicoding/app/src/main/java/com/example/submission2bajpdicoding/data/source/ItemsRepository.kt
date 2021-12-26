package com.example.submission2bajpdicoding.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.submission2bajpdicoding.data.source.local.entity.Items
import com.example.submission2bajpdicoding.data.source.remote.RemoteDataSource
import com.example.submission2bajpdicoding.data.source.remote.response.MovieItem
import com.example.submission2bajpdicoding.data.source.remote.response.TvShowItems

class ItemsRepository private constructor(
    private val remoteDataSource: RemoteDataSource
): ItemsDataSource{

    override fun getAllMovies(): LiveData<List<Items>> {
        val movieResult = MutableLiveData<List<Items>>()
        remoteDataSource.getMovies(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMoviesReceived(movieItemResponse: List<MovieItem>?) {
                val movieList = ArrayList<Items>()
                if (movieItemResponse != null) {
                    for (movie in movieItemResponse) {
                        with(movie) {
                            movieList.add(
                                Items(
                                    id,
                                    title,
                                    releaseDate,
                                    originalTitle,
                                    popularity,
                                    voteAverage,
                                    overview,
                                    posterPath,
                                )
                            )
                        }
                    }
                }
                movieResult.postValue(movieList)
            }
        })
        return movieResult
    }

    override fun getMovieById(Id: String): LiveData<Items> {
        val movieResult = MutableLiveData<Items>()
        remoteDataSource.getMovies(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMoviesReceived(movieItemResponse: List<MovieItem>?) {
                lateinit var selectedMovieShow : Items
                if (movieItemResponse != null) {
                    for (movie in movieItemResponse) {
                        if(Id == movie.id.toString()){
                            with(movie) {
                                selectedMovieShow =
                                    Items(
                                        id,
                                        title,
                                        releaseDate,
                                        originalTitle,
                                        popularity,
                                        voteAverage,
                                        overview,
                                        posterPath
                                    )
                            }
                        }
                    }
                }
                movieResult.postValue(selectedMovieShow)
            }
        })
        return movieResult
    }

    override fun getAllTvShows(): LiveData<List<Items>> {
        val tvShowResult = MutableLiveData<List<Items>>()
        remoteDataSource.getTvShow(object : RemoteDataSource.LoadTVCallback {
            override fun onAllTvShowsReceived(tvItemResponse: List<TvShowItems>?) {
                val tvShowList = ArrayList<Items>()
                if (tvItemResponse != null) {
                    for (tvShow in tvItemResponse) {
                        with(tvShow) {
                            tvShowList.add(
                                Items(
                                    id,
                                    name,
                                    firstAirDate,
                                    originalTitle,
                                    popularity,
                                    voteAverage,
                                    overview,
                                    posterPath
                                )
                            )
                        }
                    }
                }
                tvShowResult.postValue(tvShowList)
            }
        })
        return tvShowResult
    }

    override fun getTvShowsById(Id: String): LiveData<Items> {
        val tvShowResult = MutableLiveData<Items>()
        remoteDataSource.getTvShow(object : RemoteDataSource.LoadTVCallback {
            override fun onAllTvShowsReceived(tvItemResponse: List<TvShowItems>?) {
                lateinit var selectedTvShow : Items
                if (tvItemResponse != null) {
                    for (tvShow in tvItemResponse) {
                        if(Id == tvShow.id.toString()){
                            with(tvShow) {
                                selectedTvShow =
                                    Items(
                                        id,
                                        name,
                                        firstAirDate,
                                        originalTitle,
                                        popularity,
                                        voteAverage,
                                        overview,
                                        posterPath
                                )
                            }
                        }
                    }
                }
                tvShowResult.postValue(selectedTvShow)
            }
        })
        return tvShowResult
    }

    companion object {
        @Volatile
        private var instance: ItemsRepository? = null

        fun getInstance(dataSource: RemoteDataSource): ItemsRepository =
            instance ?: synchronized(this) {
                instance ?: ItemsRepository(dataSource)
            }
    }
}