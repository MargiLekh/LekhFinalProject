package com.example.lekhfinalproject.model

import com.example.lekhfinalproject.data.Planning
import com.example.lekhfinalproject.data.PlanningEntity
import com.example.lekhfinalproject.model.api.ApiHelper
import com.example.lekhfinalproject.model.database.PlanningDao
import kotlin.random.Random

class PlanningRepository(private val planningDao: PlanningDao, private val apiHelper: ApiHelper) {
    val planningList = planningDao.getAll()
    suspend fun add(planning: Planning) {
        val entity = PlanningEntity(
            id = planning.title + planning.restTime,
            title = planning.title,
            description = planning.description,
            restTime = planning.restTime,
            deadlineTime = planning.deadlineTime
        )
        planningDao.insertPlanning(entity)
    }

    suspend fun getQuote(): String = apiHelper.getQuote().getOrNull(0)?.queryText ?: ""
}