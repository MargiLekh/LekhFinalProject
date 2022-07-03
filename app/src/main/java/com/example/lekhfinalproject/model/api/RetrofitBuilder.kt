package com.example.lekhfinalproject.model.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {
    private const val BASE_URL = "http://api.forismatic.com/"
    val apiService = getRetrofit().create(ApiService::class.java)

    var gson = GsonBuilder()
        .setLenient()
        .create()

    private fun getRetrofit() : Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
        GsonConverterFactory.create(gson)).build()

}