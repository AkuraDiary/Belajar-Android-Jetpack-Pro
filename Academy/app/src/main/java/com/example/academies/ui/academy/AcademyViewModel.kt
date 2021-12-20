package com.example.academies.ui.academy

import androidx.lifecycle.ViewModel
import com.example.academies.data.CourseEntity
import com.example.academies.data.source.AcademyRepository
import com.example.academies.utils.DataDummy

class AcademyViewModel (private val academyRepository: AcademyRepository) :ViewModel() {
    fun getCourses(): List<CourseEntity> = academyRepository.getAllCourses() //DataDummy.generateDummyCourses()
}