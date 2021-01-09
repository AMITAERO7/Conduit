package com.hackernight.api.services

import com.hackernight.api.model.ArticlesResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ConduitApi {
    @GET("articles")
    fun getAllArticles(): Call<ArticlesResponse>
}