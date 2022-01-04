package com.example.submission3bajpdicoding.di

import com.example.submission3bajpdicoding.data.source.ItemsRepository
import com.example.submission3bajpdicoding.utilities.AppExecutors
import org.koin.dsl.module

val repositoryModule = module {
    single { AppExecutors() }
    single { ItemsRepository(get(), get(), get()) }
}