package com.example.submission2bajpdicoding.utilities

import android.widget.ImageView
import com.example.submission2bajpdicoding.models.Items

interface DetailsDataBinding {
    fun setBinding(items: Items)
    fun multipleGlide(firstImage: ImageView, secondImage: ImageView, items: Items)
}