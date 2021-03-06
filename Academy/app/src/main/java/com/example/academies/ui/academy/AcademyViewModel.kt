package com.example.academies.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.academies.data.source.local.entity.CourseEntity
import com.example.academies.data.source.AcademyRepository
import com.example.academies.vo.Resource

class AcademyViewModel (private val academyRepository: AcademyRepository) :ViewModel() {
    fun getCourses(): LiveData<Resource<PagedList<CourseEntity>>> = academyRepository.getAllCourses()
}