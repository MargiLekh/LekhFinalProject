package com.example.lekhfinalproject.model.api

import com.example.lekhfinalproject.data.ApiResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @GET("api/1.0/")
    suspend fun getQuote(
        @Query("method") method: String = "getQuote",
        @Query("format") format: String = "text",
        @Query("lang") lang: String = "ru",
        @Query("jsonp") jsonp: String = "parseQuote"
    ) : ApiResponse
}