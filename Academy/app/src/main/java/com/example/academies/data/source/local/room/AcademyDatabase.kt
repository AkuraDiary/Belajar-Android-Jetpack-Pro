package com.example.academies.data.source.local.room

import android.content.Context
import androidx.room.*
import com.example.academies.data.source.local.entity.CourseEntity
import com.example.academies.data.source.local.entity.ModuleEntity

@Database(entities = [CourseEntity::class, ModuleEntity::class],
    version = 1,
    exportSchema = false)
abstract class AcademyDatabase : RoomDatabase(){
    abstract fun academyDao(): AcademyDao

    companion object {

        @Volatile
        private var INSTANCE: AcademyDatabase? = null

        fun getInstance(context: Context): AcademyDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AcademyDatabase::class.java,
                    "Academies.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }
}