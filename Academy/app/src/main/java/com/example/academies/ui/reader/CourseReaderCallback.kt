package com.example.academies.ui.reader

interface CourseReaderCallback {
    fun moveTo(position: Int, moduleId: String)
}