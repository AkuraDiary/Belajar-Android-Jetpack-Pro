package com.example.submission3bajpdicoding.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.submission3bajpdicoding.data.source.local.entity.Items

@Database(entities = [Items::class], version = 1, exportSchema = false)
abstract class ItemsDatabase :RoomDatabase(){
    abstract fun movieDao(): ItemsDao
}