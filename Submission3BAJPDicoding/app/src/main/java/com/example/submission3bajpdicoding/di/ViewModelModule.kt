package com.example.submission3bajpdicoding.di

import com.example.submission3bajpdicoding.ui.detail.DetailViewModel
import com.example.submission3bajpdicoding.ui.favorite.FavoriteViewModel
import com.example.submission3bajpdicoding.ui.movies.MovieViewModel
import com.example.submission3bajpdicoding.ui.tvShows.TvViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module{
    viewModel{MovieViewModel(get())}
    viewModel{TvViewModel(get())}
    viewModel { DetailViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
}