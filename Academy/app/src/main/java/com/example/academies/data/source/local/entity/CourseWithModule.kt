package com.example.academies.data.source.local.entity

import androidx.room.*

data class CourseWithModule(
    @Embedded
    var mCourse: CourseEntity,
    @Relation(parentColumn = "courseId", entityColumn = "courseId")
    var mModules: List<ModuleEntity>
)
