package com.example.academies.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.academies.data.source.local.entity.CourseEntity
import com.example.academies.data.source.local.entity.ModuleEntity
import com.example.academies.data.source.AcademyRepository

class DetailCourseViewModel (private val academyRepository: AcademyRepository) :ViewModel(){
    private lateinit var courseID: String

    fun setSelectedCourse(courseId:String){
        this.courseID = courseId
    }

    fun getCourse(): LiveData<CourseEntity> = academyRepository.getCourseWithModules(courseID)

    fun getModules(): LiveData<List<ModuleEntity>> = academyRepository.getAllModulesByCourse(courseID)

}