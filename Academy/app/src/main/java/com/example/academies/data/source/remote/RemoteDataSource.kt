package com.example.academies.data.source.remote

import android.os.Looper
import com.example.academies.data.source.remote.response.ContentResponse
import com.example.academies.data.source.remote.response.CourseResponse
import com.example.academies.data.source.remote.response.ModuleResponse
import com.example.academies.utils.JsonHelper
import android.os.Handler

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    //fun getAllCourses(): List<CourseResponse> = jsonHelper.loadCourses()

    //fun getModules(courseId: String): List<ModuleResponse> = jsonHelper.loadModule(courseId)

    //fun getContent(moduleId: String): ContentResponse = jsonHelper.loadContent(moduleId)

    fun getAllCourses(callback: LoadCoursesCallback){
        handler.postDelayed({callback.onAllCoursesReceived(jsonHelper.loadCourses())}, SERVICE_LATENCY_IN_MILIS)
    }

    fun getModules(courseId: String, callback : LoadModulesCallback){
        handler.postDelayed({callback.onAllModulesReceived(jsonHelper.loadModule())}, SERVICE_LATENCY_IN_MILIS)
    }

    fun getContent(moduleId : String, callback:LoadContentCallback){
        handler.postDelayed({callback.onContentReceived(jsonHelper.loadContent())}, SERVICE_LATENCY_IN_MILIS)
    }

    interface LoadCoursesCallback{
        fun onAllCoursesReceived(courseResponse: List<CourseResponse>)
    }

    interface LoadModulesCallback{
        fun onAllModulesReceived(moduleResponse: List<ModuleResponse>)
    }

    interface LoadContentCallback{
        fun onContentReceived(contentResponse: ContentResponse)
    }

    companion object {

        private const val SERVICE_LATENCY_IN_MILIS : Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

}