package com.example.personing.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class Person(
    val id: Long,
    val firstname: String,
    val lastname: String,
    val adult: Boolean,
    val user: User,
    val type: Type
): Parcelable {

}