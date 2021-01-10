package com.hackernight.api.model.requests


import com.hackernight.api.model.entities.UserLoginCreds
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "user")
    val user: UserLoginCreds
)