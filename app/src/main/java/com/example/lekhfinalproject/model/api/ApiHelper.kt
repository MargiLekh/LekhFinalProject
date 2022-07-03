package com.example.lekhfinalproject.model.api

class ApiHelper(private val apiService : ApiService ) {
    suspend fun getQuote() = apiService.getQuote()
}