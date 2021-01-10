package com.hackernight.conduit.data

import com.hackernight.api.ConduitClient
import com.hackernight.api.services.ConduitApi

object ArticleRepo {
    val api  = ConduitClient().api

    suspend fun getGlobalFeed() = api.getAllArticles()
}