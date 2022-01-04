package com.example.submission3bajpdicoding.di

import androidx.room.Room
import com.example.submission3bajpdicoding.data.source.local.room.ItemsDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.dsl.single

val databaseModule = module{
    factory{get<ItemsDatabase>().movieDao()}
    single{
        Room.databaseBuilder(
            androidContext(),
            ItemsDatabase::class.java,
            "tabel_items"
        ).fallbackToDestructiveMigration().build()
    }
}