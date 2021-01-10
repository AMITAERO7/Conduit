package com.hackernight.api.services

import com.hackernight.api.model.requests.SignUpRequest
import com.hackernight.api.model.requests.UserUpdateRequest
import com.hackernight.api.model.responses.ArticleResponse
import com.hackernight.api.model.responses.ArticlesResponse
import com.hackernight.api.model.responses.ProfileResponse
import com.hackernight.api.model.responses.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitAuthApi {

    @GET("user")
    suspend fun getCurrentUser():Response<UserResponse>

    @PUT("user")
    suspend fun updateCurrentUser(
        @Body userUpdateRequest: UserUpdateRequest
    ):Response<UserResponse>

    @GET("profiles/{username}")
    suspend fun getProfile(
        @Path("username") username:String
    ):Response<ProfileResponse>

    @POST("profiles/{username}/follow")
    suspend fun followProfile(
        @Path("username") username: String
    ):Response<ProfileResponse>

    @POST("profiles/{username}/follow")
    suspend fun unfollowProfile(
        @Path("username") username: String
    ):Response<ProfileResponse>

    @GET("articles/feed")
    suspend fun getFeedArticles():Response<ArticlesResponse>

    @POST("articles/{slug}/favorite")
    suspend fun favoriteArticle(
        @Path("slug") slug:String
    ):Response<ArticleResponse>

    @POST("articles/{slug}/favorite")
    suspend fun unfavoriteArticle(
        @Path("slug") slug:String
    ):Response<ArticleResponse>

}