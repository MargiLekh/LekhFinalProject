package com.example.lekhfinalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lekhfinalproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val framgent = PlanningListFramgent()
        supportFragmentManager.beginTransaction()
            .add(R.id.container, framgent)
            .commit()
    }
}