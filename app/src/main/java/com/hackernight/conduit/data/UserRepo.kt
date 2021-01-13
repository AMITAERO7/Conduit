package com.hackernight.conduit.data

import com.hackernight.api.ConduitClient
import com.hackernight.api.model.entities.UserLoginCreds
import com.hackernight.api.model.requests.LoginRequest
import com.hackernight.api.model.responses.UserResponse

object UserRepo {
    val api = ConduitClient().api

    suspend fun login(email:String,password:String): UserResponse? {
        val response = api.loginUser(LoginRequest(UserLoginCreds(email,password)))
        return response.body()
    }

}