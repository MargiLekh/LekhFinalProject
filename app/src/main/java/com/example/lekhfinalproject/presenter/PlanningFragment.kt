package com.example.lekhfinalproject.presenter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lekhfinalproject.R
import com.example.lekhfinalproject.data.Planning
import com.example.lekhfinalproject.databinding.FragmentPlanningBinding

class PlanningFragment : Fragment(R.layout.fragment_planning) {
    private val args: PlanningFragmentArgs by navArgs()
    //private val planning : Planning? = args.planning
    private val binding: FragmentPlanningBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.title.setText(args.planning?.title ?: "")
    }
}