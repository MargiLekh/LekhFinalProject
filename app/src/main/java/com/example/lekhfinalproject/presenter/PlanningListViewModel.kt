package com.example.lekhfinalproject.presenter

import androidx.lifecycle.ViewModel
import com.example.lekhfinalproject.model.PlanningRepository
import com.example.lekhfinalproject.model.database.AppDatabase

class PlanningListViewModel: ViewModel() {
    private val database = AppDatabase.getDatabase()
    private val repository = PlanningRepository(database!!.planningDao())
    val planningList = repository.planningList
}