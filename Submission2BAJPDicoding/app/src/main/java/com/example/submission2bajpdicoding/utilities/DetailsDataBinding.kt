package com.example.submission2bajpdicoding.utilities

import android.widget.ImageView
import androidx.lifecycle.LiveData
import com.example.submission2bajpdicoding.data.source.local.entity.Items

interface DetailsDataBinding {
    fun setBinding(items: LiveData<Items>)
    fun multipleGlide(firstImage: ImageView, secondImage: ImageView, items: LiveData<Items>)
}