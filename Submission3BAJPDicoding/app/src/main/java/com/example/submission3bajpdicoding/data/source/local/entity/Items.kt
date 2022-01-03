package com.example.submission3bajpdicoding.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Items(
    val id: Int? = 0,
    var title: String? = null,
    var ReleaseDate: String? = null,
    var OriginalTitle: String? = null,
    var popularity: Double? = null,
    var score: Double? = null,
    var synopsis: String? = null,
    var poster: String? = null
): Parcelable
