package com.example.submission3bajpdicoding

import android.app.Application
import com.example.submission3bajpdicoding.di.appModule
import com.example.submission3bajpdicoding.di.databaseModule
import com.example.submission3bajpdicoding.di.repositoryModule
import com.example.submission3bajpdicoding.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    appModule,
                    repositoryModule,
                    viewModelModule,
                    databaseModule
                )
            )
        }
    }
}