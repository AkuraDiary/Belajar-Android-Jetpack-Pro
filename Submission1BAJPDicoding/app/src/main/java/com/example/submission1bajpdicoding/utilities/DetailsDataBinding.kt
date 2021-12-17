package com.example.submission1bajpdicoding.utilities

import android.widget.ImageView
import com.example.submission1bajpdicoding.models.Items

interface DetailsDataBinding {
    fun setBinding(items: Items)
    fun multipleGlide(firstImage: ImageView, secondImage: ImageView, items: Items)
}