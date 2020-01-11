package com.reindrairawan.submission2.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var photo: Int,
    var judul: String,
    var description: String

) : Parcelable


