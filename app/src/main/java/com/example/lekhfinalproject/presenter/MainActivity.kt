package com.example.lekhfinalproject.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.lekhfinalproject.R
import com.example.lekhfinalproject.model.database.AppDatabase

class MainActivity : AppCompatActivity() {

    //private val binding: ActivityMainBinding by viewBinding()
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppDatabase.invoke(applicationContext)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        navHostFragment.findNavController().setGraph(R.navigation.planning_graph)

        //navController = Navigation.findNavController(this, R.id.container);
//        val framgent = PlanningListFramgent()
//        supportFragmentManager.beginTransaction()
//            .add(R.id.container, framgent)
//            .commit()
    }
}