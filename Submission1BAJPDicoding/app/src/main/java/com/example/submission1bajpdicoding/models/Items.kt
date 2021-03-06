package com.example.submission1bajpdicoding.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Items(
    val id : Int? = 0,
    var judul: String? = null,
    var waktuRelease: String? = null,
    var genre: String? = null,
    var durasi: String? = null,
    var score: String? = null,
    var sinopsis: String? = null,
    var poster: Int? = 0
): Parcelable
