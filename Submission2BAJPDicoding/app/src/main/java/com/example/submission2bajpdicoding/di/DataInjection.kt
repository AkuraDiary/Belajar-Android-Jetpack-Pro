package com.example.submission2bajpdicoding.di

import com.example.submission2bajpdicoding.data.source.ItemsRepository
import com.example.submission2bajpdicoding.data.source.remote.RemoteDataSource

object DataInjection {
    fun provideRepository(): ItemsRepository {
        val remoteRepository = RemoteDataSource.getInstance()
        return ItemsRepository.getInstance(remoteRepository)
    }
}