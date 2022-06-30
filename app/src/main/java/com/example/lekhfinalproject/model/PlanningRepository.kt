package com.example.lekhfinalproject.model

import com.example.lekhfinalproject.data.Planning
import com.example.lekhfinalproject.data.PlanningEntity
import com.example.lekhfinalproject.model.database.PlanningDao

class PlanningRepository(private val planningDao: PlanningDao) {
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
}