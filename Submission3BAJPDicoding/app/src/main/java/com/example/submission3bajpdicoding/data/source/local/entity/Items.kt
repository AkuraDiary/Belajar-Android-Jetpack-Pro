package com.example.submission3bajpdicoding.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabel_items")
data class Items(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int? = 0,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "ReleaseDate")
    var ReleaseDate: String? = null,

    @ColumnInfo(name = "OriginalTitle")
    var OriginalTitle: String? = null,

    @ColumnInfo(name = "popularity")
    var popularity: Double? = null,

    @ColumnInfo(name = "score")
    var score: Double? = null,

    @ColumnInfo(name = "synopsis")
    var synopsis: String? = null,

    @ColumnInfo(name = "poster")
    var poster: String? = null,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false,

    @ColumnInfo(name = "isTvShow")
    var isTvShow: Boolean = false
)
