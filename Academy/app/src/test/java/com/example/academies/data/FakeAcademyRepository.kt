package com.example.academies.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.academies.data.source.AcademyDataSource
import com.example.academies.data.source.remote.RemoteDataSource
import com.example.academies.data.source.remote.response.ContentResponse
import com.example.academies.data.source.remote.response.CourseResponse
import com.example.academies.data.source.remote.response.ModuleResponse

class FakeAcademyRepository(private val remoteDataSource: RemoteDataSource) : AcademyDataSource {

    override fun getAllCourses(): LiveData<List<CourseEntity>> {
        val courseResults = MutableLiveData<List<CourseEntity>>()
        remoteDataSource.getAllCourses(object : RemoteDataSource.LoadCoursesCallback {
            override fun onAllCoursesReceived(courseResponses: List<CourseResponse>) {
                val courseList = ArrayList<CourseEntity>()
                for (i in courseResponses.indices) {
                    val response = courseResponses[i]
                    val course = CourseEntity(response.id,
                        response.title,
                        response.description,
                        response.date,
                        false,
                        response.imagePath)

                    courseList.add(course)
                }
                courseResults.postValue(courseList)
            }
        })

        return courseResults
    }

    override fun getBookmarkedCourses(): LiveData<List<CourseEntity>> {
        val courseResults = MutableLiveData<List<CourseEntity>>()

        remoteDataSource.getAllCourses(object : RemoteDataSource.LoadCoursesCallback {
            override fun onAllCoursesReceived(courseResponses: List<CourseResponse>) {
                val courseList = ArrayList<CourseEntity>()
                for (i in courseResponses.indices) {
                    val response = courseResponses[i]
                    val course = CourseEntity(response.id,
                        response.title,
                        response.description,
                        response.date,
                        false,
                        response.imagePath)
                    courseList.add(course)
                }
                courseResults.postValue(courseList)
            }
        })
        return courseResults
    }

    override fun getCourseWithModules(courseId: String): LiveData<CourseEntity> {
        val courseResult = MutableLiveData<CourseEntity>()

        remoteDataSource.getAllCourses(object : RemoteDataSource.LoadCoursesCallback {
            override fun onAllCoursesReceived(courseResponses: List<CourseResponse>) {
                for (i in courseResponses.indices) {
                    val response = courseResponses[i]
                    if (response.id == courseId) {
                        val course = CourseEntity(response.id,
                            response.title,
                            response.description,
                            response.date,
                            false,
                            response.imagePath)
                        courseResult.postValue(course)
                    }
                }
            }
        })

        return courseResult
    }

    override fun getAllModulesByCourse(courseId: String): LiveData<List<ModuleEntity>> {
        val moduleResults = MutableLiveData<List<ModuleEntity>>()

        remoteDataSource.getModules(courseId, object : RemoteDataSource.LoadModulesCallback {
            override fun onAllModulesReceived(moduleResponses: List<ModuleResponse>) {
                val moduleList = ArrayList<ModuleEntity>()
                for (i in moduleResponses.indices) {
                    val response = moduleResponses[i]
                    val course = ModuleEntity(response.moduleId,
                        response.courseId,
                        response.title,
                        response.position,
                        false)

                    moduleList.add(course)
                }
                moduleResults.postValue(moduleList)
            }
        })

        return moduleResults
    }

    override fun getContent(courseId: String, moduleId: String): LiveData<ModuleEntity> {
        val moduleResult = MutableLiveData<ModuleEntity>()

        remoteDataSource.getModules(courseId, object : RemoteDataSource.LoadModulesCallback {
            override fun onAllModulesReceived(moduleResponses: List<ModuleResponse>) {
                val module: ModuleEntity
                for (i in moduleResponses.indices) {
                    val moduleResponses = moduleResponses[i]

                    val id = moduleResponses.moduleId

                    if (id == moduleId) {
                        module = ModuleEntity(id, moduleResponses.courseId, moduleResponses.title, moduleResponses.position, false)

                        remoteDataSource.getContent(moduleId, object : RemoteDataSource.LoadContentCallback {
                            override fun onContentReceived(contentResponses: ContentResponse) {
                                module.contentEntity = ContentEntity(contentResponses.content)
                                moduleResult.postValue(module)
                            }
                        })
                        break
                    }
                }
            }
        })
        return moduleResult
    }
}
