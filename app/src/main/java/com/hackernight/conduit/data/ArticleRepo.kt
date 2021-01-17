package com.hackernight.conduit.data

import com.hackernight.api.ConduitClient

object ArticleRepo {
    val api  = ConduitClient.publicApi

    suspend fun getGlobalFeed() = api.getAllArticles()
}