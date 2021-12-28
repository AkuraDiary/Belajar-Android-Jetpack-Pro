package com.example.academies.di

import android.content.Context
import com.example.academies.data.source.AcademyRepository
import com.example.academies.data.source.local.LocalDataSource
import com.example.academies.data.source.local.room.AcademyDatabase
import com.example.academies.data.source.remote.RemoteDataSource
import com.example.academies.utils.AppExecutors
import com.example.academies.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {

        val database = AcademyDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.academyDao())
        val appExecutors = AppExecutors()

        return AcademyRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}