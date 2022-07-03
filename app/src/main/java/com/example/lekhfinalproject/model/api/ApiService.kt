package com.example.lekhfinalproject.model.api

import com.example.lekhfinalproject.data.ApiResultQuote
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/")
    suspend fun getQuote(
        @Query("api") api: String = "random"
    ): List<ApiResultQuote>
}