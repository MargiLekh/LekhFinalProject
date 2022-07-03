package com.example.lekhfinalproject.presenter

import androidx.lifecycle.ViewModel
import com.example.lekhfinalproject.model.PlanningRepository
import com.example.lekhfinalproject.model.api.ApiHelper
import com.example.lekhfinalproject.model.api.RetrofitBuilder
import com.example.lekhfinalproject.model.database.AppDatabase

class PlanningListViewModel: ViewModel() {
    private val database = AppDatabase.getDatabase()
    private val apiHelper = ApiHelper(RetrofitBuilder.apiService)
    private val repository = PlanningRepository(database!!.planningDao(), apiHelper)
    val planningList = repository.planningList
}