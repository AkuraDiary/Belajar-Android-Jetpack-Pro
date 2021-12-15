package com.example.academies.ui.bookmark

import androidx.lifecycle.ViewModel
import com.example.academies.data.CourseEntity
import com.example.academies.utils.DataDummy

class BookmarkViewModel: ViewModel() {
    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()
}