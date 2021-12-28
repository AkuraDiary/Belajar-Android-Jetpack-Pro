package com.example.academies.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.academies.data.source.local.entity.CourseEntity
import com.example.academies.data.source.AcademyRepository
import com.example.academies.vo.Resource

class AcademyViewModel (private val academyRepository: AcademyRepository) :ViewModel() {
    fun getCourses(): LiveData<Resource<List<CourseEntity>>> = academyRepository.getAllCourses()
}