package com.hackernight.api.model.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserUpdateData(
    @Json(name = "bio")
    val bio: String,
    @Json(name="username")
    val userName:String,
    @Json(name = "image")
    val image: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password:String
)