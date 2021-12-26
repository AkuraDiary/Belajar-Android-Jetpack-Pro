package com.example.submission2bajpdicoding.utilities

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.submission2bajpdicoding.data.source.ItemsRepository
import com.example.submission2bajpdicoding.di.DataInjection
import com.example.submission2bajpdicoding.ui.detail.DetailViewModel
import com.example.submission2bajpdicoding.ui.movies.MovieViewModel
import com.example.submission2bajpdicoding.ui.tvShows.TvViewModel
import kotlinx.coroutines.internal.synchronized

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

         fun getInstance(context: Context): ViewModelFactory=
             instance ?: kotlin.synchronized(this){
                 instance ?: ViewModelFactory(DataInjection.provideRepository(context))
             }
     }
}