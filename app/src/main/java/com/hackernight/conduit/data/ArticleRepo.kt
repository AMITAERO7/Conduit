package com.hackernight.conduit.data

import com.hackernight.api.ConduitClient

object ArticleRepo {
    val api  = ConduitClient.publicApi
    val authApi = ConduitClient.authApi

    suspend fun getGlobalFeed() = api.getAllArticles()

    suspend fun getMyFeed() = authApi.getFeedArticles()

    suspend fun getArticles(slug:String) = api.getArticleSlug(slug)
}