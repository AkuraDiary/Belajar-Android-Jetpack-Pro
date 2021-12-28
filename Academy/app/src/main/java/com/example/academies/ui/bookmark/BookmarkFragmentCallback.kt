package com.example.academies.ui.bookmark

import com.example.academies.data.source.local.entity.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)

}
