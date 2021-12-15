package com.example.academies.ui.academy

import androidx.lifecycle.ViewModel
import com.example.academies.data.CourseEntity
import com.example.academies.utils.DataDummy

class AcademyViewModel:ViewModel() {
    fun getCourses(): List<CourseEntity> = DataDummy.generateDummyCourses()
}