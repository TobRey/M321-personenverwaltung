package com.example.personing.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class Type(
    val id: Long,
    val label: String
) : Parcelable {
}