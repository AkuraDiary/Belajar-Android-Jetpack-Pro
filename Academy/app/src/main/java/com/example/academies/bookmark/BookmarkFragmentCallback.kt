package com.example.academies.bookmark

import com.example.academies.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course:CourseEntity)

}
