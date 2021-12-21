package com.example.academies.ui.bookmark

import androidx.lifecycle.ViewModel
import com.example.academies.data.CourseEntity
import com.example.academies.data.source.AcademyRepository


class BookmarkViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    fun getBookmarks(): List<CourseEntity> = academyRepository.getBookmarkedCourses() //DataDummy.generateDummyCourses()
}