package com.example.submission3bajpdicoding.utilities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.submission3bajpdicoding.data.source.ItemsRepository
import com.example.submission3bajpdicoding.di.DataInjection
import com.example.submission3bajpdicoding.ui.detail.DetailViewModel
import com.example.submission3bajpdicoding.ui.movies.MovieViewModel
import com.example.submission3bajpdicoding.ui.tvShows.TvViewModel

class ViewModelFactory private constructor(
    private val itemsRepository: ItemsRepository
 ): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(itemsRepository) as T
            }
            modelClass.isAssignableFrom(TvViewModel::class.java) -> {
                TvViewModel(itemsRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(itemsRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class : " + modelClass.name)
        }
    }

     companion object{
         @Volatile
         private var instance: ViewModelFactory? = null

         fun getInstance(): ViewModelFactory=
             instance ?: synchronized(this){
                 instance ?: ViewModelFactory(DataInjection.provideRepository())
             }
     }
}