package com.example.submission2bajpdicoding.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Items(
    val id : Int? = 0,
    var judul: String? = null,
    var waktuRelease: String? = null,
    var OriginalTitle: String? = null,
    var popularity: String? = null,
    var score: String? = null,
    var sinopsis: String? = null,
    var poster: String? = null
): Parcelable
