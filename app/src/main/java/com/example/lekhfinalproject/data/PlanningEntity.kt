package com.example.lekhfinalproject.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "planning")
data class PlanningEntity (
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val restTime: String,
    val deadlineTime: String
)