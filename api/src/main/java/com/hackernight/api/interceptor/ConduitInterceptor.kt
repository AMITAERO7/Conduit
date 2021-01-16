package com.hackernight.api.interceptor

import okhttp3.Interceptor
import okhttp3.Response

object ConduitInterceptor : Interceptor {

    var authToken : String? = null

    override fun intercept(chain: Interceptor.Chain): Response {
        var request  = chain.request()

        authToken?.let {
            request = request.newBuilder()
                .header("Authorization","Token $it")
                .build()
        }

        return chain.proceed(request)
    }

}