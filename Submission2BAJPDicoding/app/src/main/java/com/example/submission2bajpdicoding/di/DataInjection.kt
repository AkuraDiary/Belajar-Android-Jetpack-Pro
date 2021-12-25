package com.example.submission2bajpdicoding.di

import android.content.Context
import com.example.submission2bajpdicoding.data.source.ItemsRepository

object DataInjection {
    fun provideRepository(context : Context): ItemsRepository {
        val remoteRepository = RemoteDataSource.getInstance()
        return ItemsRepository.getInstance(remoteRepository)
    }
}