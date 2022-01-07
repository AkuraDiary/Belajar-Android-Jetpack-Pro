package com.example.submission3bajpdicoding.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.submission3bajpdicoding.data.source.ItemsRepository
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.vo.Resource

class DetailViewModel(private val itemsRepository: ItemsRepository) : ViewModel(){
    private val movieId = MutableLiveData<Int>()
    private val tvId = MutableLiveData<Int>()

    fun setSelectedMovie(movieID: Int){
        this.movieId.value = movieID
    }

    fun setSelectedTV(tvShowId: Int){
        this.tvId.value = tvShowId
    }

    var movieDetail: LiveData<Resource<Items>> =
        Transformations.switchMap(movieId){
        id -> itemsRepository.getMovieById(id)
    }

    var tvDetail: LiveData<Resource<Items>> =
        Transformations.switchMap(tvId){
        id -> itemsRepository.getTvShowsById(id)
    }

    fun setFavoriteMovie(){
        val movieResource = movieDetail.value?.data
        if (movieResource != null){
            val newState = !movieResource.isFavorite
            itemsRepository.setToFavorite(movieResource, newState)
        }
    }

    fun setFavoriteTv(){
        val tvShowResource = tvDetail.value?.data
        if(tvShowResource != null){
            val newState = !tvShowResource.isFavorite
            itemsRepository.setToFavorite(tvShowResource, newState)
        }
    }
    //fun getSelectedMovie(ID: String):LiveData<Items> = itemsRepository.getMovieById(ID)
    //fun getSelectedTV(ID : String): LiveData<Items> = itemsRepository.getTvShowsById(ID)
}