package com.example.submission3bajpdicoding.di

import com.example.submission3bajpdicoding.data.source.local.LocalDataSource
import com.example.submission3bajpdicoding.data.source.remote.RemoteDataSource
import com.example.submission3bajpdicoding.networking.NetworkClient
import org.koin.dsl.module

val appModule = module{
    single{NetworkClient.getApiService()}
    single { RemoteDataSource() }
    single { LocalDataSource(get()) }
}