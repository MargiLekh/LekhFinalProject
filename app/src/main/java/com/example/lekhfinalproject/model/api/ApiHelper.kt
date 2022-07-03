package com.example.lekhfinalproject.model.api

import com.example.lekhfinalproject.data.ApiResultQuote

class ApiHelper(private val apiService : ApiService ) {
    suspend fun getQuote() : List<ApiResultQuote> = apiService.getQuote()
}