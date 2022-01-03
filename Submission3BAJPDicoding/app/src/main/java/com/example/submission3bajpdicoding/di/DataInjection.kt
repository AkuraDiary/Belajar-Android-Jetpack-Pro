package com.example.submission3bajpdicoding.di

import com.example.submission3bajpdicoding.data.source.ItemsRepository
import com.example.submission3bajpdicoding.data.source.remote.RemoteDataSource

object DataInjection {
    fun provideRepository(): ItemsRepository {
        val remoteRepository = RemoteDataSource.getInstance()
        return ItemsRepository.getInstance(remoteRepository)
    }
}