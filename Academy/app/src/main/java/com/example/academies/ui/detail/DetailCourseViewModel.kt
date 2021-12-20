package com.example.academies.ui.detail

import androidx.lifecycle.ViewModel
import com.example.academies.data.CourseEntity
import com.example.academies.data.ModuleEntity
import com.example.academies.data.source.AcademyRepository
import com.example.academies.utils.DataDummy

class DetailCourseViewModel (private val academyRepository: AcademyRepository) :ViewModel(){
    private lateinit var courseID: String

    fun setSelectedCourse(courseId:String){
        this.courseID = courseId
    }

    fun getCourse(): CourseEntity = academyRepository.getCourseWithModules(courseID)

    fun getModules(): List<ModuleEntity> = academyRepository.getAllModulesByCourse(courseID)

    /*fun getCourse(): CourseEntity{
        lateinit var course: CourseEntity
        val coursesEntities = DataDummy.generateDummyCourses()

        for (courseEntity in coursesEntities){
            if(courseEntity.courseId == courseID){
                course = courseEntity
            }
        }

        return course
    }*/

    /*fun getModules(): List<ModuleEntity> = DataDummy.generateDummyModules(courseID)*/
}