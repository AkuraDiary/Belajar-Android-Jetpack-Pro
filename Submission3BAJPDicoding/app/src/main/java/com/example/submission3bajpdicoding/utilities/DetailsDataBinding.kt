package com.example.submission3bajpdicoding.utilities

import android.widget.ImageView
import com.example.submission3bajpdicoding.data.source.local.entity.Items

interface DetailsDataBinding {
    fun setBinding(items: Items)
    fun multipleGlide(firstImage: ImageView, secondImage: ImageView, items: Items)
}