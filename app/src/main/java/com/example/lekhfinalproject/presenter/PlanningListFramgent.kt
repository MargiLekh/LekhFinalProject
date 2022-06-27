package com.example.lekhfinalproject.presenter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lekhfinalproject.R
import com.example.lekhfinalproject.adapter.CustomRecyclerAdapter
import com.example.lekhfinalproject.data.Planning
import com.example.lekhfinalproject.databinding.FragmentPlanningListBinding

class PlanningListFramgent: Fragment(R.layout.fragment_planning_list) {
    private val binding: FragmentPlanningListBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.list.adapter = CustomRecyclerAdapter(requireActivity().supportFragmentManager,planningList)
    }

    companion object {
        val planningList = listOf<Planning>(
            Planning("title1", "descr1", "16d", "15d"),
            Planning("title2", "descr1 descr1", "16d", "15d"),
            Planning("title3", "descr1 descr1 descr1 descr1 descr1 descr1", "16d", "15d"),
            Planning("title4", "descr1 descr1 descr", "16d", "15d"),
            Planning("title5", "descr1 descr1 descr1 descr1 descr1 descr1descr1 descr1", "16d", "15d"),
            Planning("title6", "descr1", "16d", "15d"),
            Planning("title7", "descr1descr1 descr1 descr1 descr1", "16d", "15d"),
            Planning("title8", "descr1 descr1descr1descr1 descr1descr1 descr1", "16d", "15d")
        )
    }
}