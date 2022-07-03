package com.example.lekhfinalproject.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {
    private const val BASE_URL = "https://zenquotes.io/"
    val apiService = getRetrofit().create(ApiService::class.java)

    private fun getRetrofit(): Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
        GsonConverterFactory.create()
    ).build()

}