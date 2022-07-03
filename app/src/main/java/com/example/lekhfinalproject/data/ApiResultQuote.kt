package com.example.lekhfinalproject.data

import com.google.gson.annotations.SerializedName

data class ApiResultQuote (
    @SerializedName("q")
    val queryText: String
)
