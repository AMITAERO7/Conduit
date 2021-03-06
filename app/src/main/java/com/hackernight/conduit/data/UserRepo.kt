package com.hackernight.conduit.data

import com.hackernight.api.ConduitClient
import com.hackernight.api.interceptor.ConduitInterceptor
import com.hackernight.api.model.entities.UserCreds
import com.hackernight.api.model.entities.UserLoginCreds
import com.hackernight.api.model.entities.UserUpdateData
import com.hackernight.api.model.requests.LoginRequest
import com.hackernight.api.model.requests.SignUpRequest
import com.hackernight.api.model.requests.UserUpdateRequest
import com.hackernight.api.model.responses.UserResponse

object UserRepo {

    val api = ConduitClient.publicApi
    val authApi = ConduitClient.authApi

    suspend fun getCurrentUser(token:String):UserResponse? {
        ConduitInterceptor.authToken = token
        val response = authApi.getCurrentUser()
        return response.body()
    }

    suspend fun login(email:String,password:String): UserResponse? {
        val response = api.loginUser(LoginRequest(UserLoginCreds(email,password)))
        ConduitInterceptor.authToken = response.body()?.user?.token
        return response.body()
    }

    suspend fun signUp(userName:String,email: String,password: String):UserResponse?{
        val response = api.signUpUser(SignUpRequest(UserCreds(email,password,userName)))
        ConduitInterceptor.authToken = response?.body()?.user?.token
        return response.body()
    }

    suspend fun getCurrentProfile() :UserResponse?{
        val response = authApi.getCurrentUser()
        return response.body()
    }

    suspend fun updateCurrentUser(bio:String,userName: String,image:String,email:String,password: String):UserResponse?{
        val response = authApi.updateCurrentUser(UserUpdateRequest(UserUpdateData(bio,userName,image,email,password)))
        return response.body()
    }

}