package com.example.lekhfinalproject.data

import java.io.Serializable

data class Planning(

    val title: String,
    val description: String,
    val restTime: String,
    val deadlineTime: String
) : Serializable
