package com.example.lekhfinalproject.presenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lekhfinalproject.data.Planning
import com.example.lekhfinalproject.model.PlanningRepository
import com.example.lekhfinalproject.model.api.ApiHelper
import com.example.lekhfinalproject.model.api.RetrofitBuilder
import com.example.lekhfinalproject.model.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlanningViewModel : ViewModel() {
    private val database = AppDatabase.getDatabase()
    private val apiHelper = ApiHelper(RetrofitBuilder.apiService)
    private val repository = PlanningRepository(database!!.planningDao(), apiHelper)
    val quote = MutableLiveData<String?>(null)

    fun add(planning: Planning) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.add(planning)
        }
    }

    fun getQuote() = viewModelScope.launch(Dispatchers.IO) {
        val result = repository.getQuote()
        quote.postValue(result)
    }

}
