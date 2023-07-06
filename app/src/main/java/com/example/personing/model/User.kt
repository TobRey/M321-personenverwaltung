package com.example.personing.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class User(
    val id: Long,
    val firstname: String,
    val lastname: String,
    val email: String,
    val token: String
) : Parcelable {
}