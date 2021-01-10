package com.hackernight.api.services

import com.hackernight.api.model.entities.UserCreds
import com.hackernight.api.model.requests.LoginRequest
import com.hackernight.api.model.requests.SignUpRequest
import com.hackernight.api.model.responses.ArticleResponse
import com.hackernight.api.model.responses.ArticlesResponse
import com.hackernight.api.model.responses.TagsResponse
import com.hackernight.api.model.responses.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitApi {

    @POST("users")
    suspend fun signUpUser(
        @Body userCreds: SignUpRequest
    ):Response<UserResponse>

    @POST("users")
    suspend fun loginUser(
        @Body userCreds: LoginRequest
    ):Response<UserResponse>

    @GET("articles")
    suspend fun getAllArticles(
        @Query("author") author:String? = null,
        @Query("favorited")favorited:String?=null ,
        @Query("tag") tag:String?=null
    ): Response<ArticlesResponse>

    @GET("articles/{slug}")
    suspend fun getArticleSlug(
        @Path("slug") slug:String
    ):Response<ArticleResponse>

    @GET("tags")
    suspend fun getTags():Response<TagsResponse>

}