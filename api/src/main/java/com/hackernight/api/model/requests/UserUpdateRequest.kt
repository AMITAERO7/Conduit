package com.hackernight.api.model.requests


import com.hackernight.api.model.entities.UserUpdate
import com.hackernight.api.model.entities.UserUpdateData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserUpdateRequest(
    @Json(name = "user")
    val user: UserUpdateData
)