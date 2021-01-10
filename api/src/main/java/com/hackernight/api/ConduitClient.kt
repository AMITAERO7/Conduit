package com.hackernight.api

import com.hackernight.api.services.ConduitApi
import com.hackernight.api.services.ConduitAuthApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ConduitClient {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://conduit.productionready.io/api/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api = retrofit.create(ConduitApi::class.java)

    val authApi = retrofit.create(ConduitAuthApi::class.java)

}