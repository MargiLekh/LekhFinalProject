package com.example.lekhfinalproject.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.lekhfinalproject.data.PlanningEntity

@Dao
interface PlanningDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlanning (planning: PlanningEntity)
    @Query("SELECT * FROM planning")
    fun getAll(): LiveData<List<PlanningEntity>>
}