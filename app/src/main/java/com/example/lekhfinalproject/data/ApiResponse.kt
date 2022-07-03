package com.example.lekhfinalproject.data

import com.google.gson.annotations.SerializedName

data class ApiResponse (
    @SerializedName("quoteText")
    val queryText: String
)