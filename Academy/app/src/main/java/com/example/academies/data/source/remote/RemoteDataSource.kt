package com.example.academies.data.source.remote

import android.os.Looper
import com.example.academies.data.source.remote.response.ContentResponse
import com.example.academies.data.source.remote.response.CourseResponse
import com.example.academies.data.source.remote.response.ModuleResponse
import com.example.academies.utils.JsonHelper
import android.os.Handler
import com.example.academies.utils.EspressoIdlingResource

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    fun getAllCourses(callback: LoadCoursesCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllCoursesReceived(jsonHelper.loadCourses())
            EspressoIdlingResource.decrement()}, SERVICE_LATENCY_IN_MILIS)
    }

    fun getModules(courseId: String, callback : LoadModulesCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllModulesReceived(jsonHelper.loadModule(courseId))
            EspressoIdlingResource.decrement()}, SERVICE_LATENCY_IN_MILIS)
    }

    fun getContent(moduleId : String, callback:LoadContentCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onContentReceived(jsonHelper.loadContent(moduleId))
            EspressoIdlingResource.decrement()}, SERVICE_LATENCY_IN_MILIS)
    }

    interface LoadCoursesCallback{
        fun onAllCoursesReceived(courseResponses: List<CourseResponse>)
    }

    interface LoadModulesCallback{
        fun onAllModulesReceived(moduleResponses: List<ModuleResponse>)
    }

    interface LoadContentCallback{
        fun onContentReceived(contentResponses: ContentResponse)
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