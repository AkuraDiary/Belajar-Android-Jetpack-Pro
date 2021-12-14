package com.example.academies.reader

interface CourseReaderCallback {
    fun moveTo(position: Int, moduleId: String)
}