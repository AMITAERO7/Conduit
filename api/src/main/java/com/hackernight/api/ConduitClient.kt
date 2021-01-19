package com.hackernight.api

import com.hackernight.api.interceptor.ConduitInterceptor
import com.hackernight.api.services.ConduitApi
import com.hackernight.api.services.ConduitAuthApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ConduitClient {

    val okhttpBuilder = OkHttpClient.Builder()
        .readTimeout(5,TimeUnit.SECONDS)
        .connectTimeout(2,TimeUnit.SECONDS)


    val retrofitBuilder = Retrofit.Builder()
        .baseUrl("https://conduit.productionready.io/api/")
        .addConverterFactory(MoshiConverterFactory.create())

    val publicApi = retrofitBuilder.client(okhttpBuilder.build())
                        .build()
                        .create(ConduitApi::class.java)

    val authApi = retrofitBuilder.client(okhttpBuilder.addInterceptor(ConduitInterceptor).build())
                        .build()
                        .create(ConduitAuthApi::class.java)

}