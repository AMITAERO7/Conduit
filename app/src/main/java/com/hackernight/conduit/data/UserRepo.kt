package com.hackernight.conduit.data

import com.hackernight.api.ConduitClient
import com.hackernight.api.interceptor.ConduitInterceptor
import com.hackernight.api.model.entities.UserLoginCreds
import com.hackernight.api.model.requests.LoginRequest
import com.hackernight.api.model.responses.UserResponse

object UserRepo {

    val api = ConduitClient.publicApi
    val authApi = ConduitClient.authApi

    suspend fun login(email:String,password:String): UserResponse? {
        val response = api.loginUser(LoginRequest(UserLoginCreds(email,password)))
        ConduitInterceptor.authToken = response.body()?.user?.token
        return response.body()
    }

    suspend fun getCurrentProfile() :UserResponse?{
        val response = authApi.getCurrentUser()
        return response.body()
    }
}