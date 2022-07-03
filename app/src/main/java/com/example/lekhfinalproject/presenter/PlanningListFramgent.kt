package com.example.lekhfinalproject.presenter

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lekhfinalproject.R
import com.example.lekhfinalproject.adapter.CustomRecyclerAdapter
import com.example.lekhfinalproject.databinding.FragmentPlanningListBinding

class PlanningListFramgent : Fragment(R.layout.fragment_planning_list) {
    private val binding: FragmentPlanningListBinding by viewBinding()
    private val customRecyclerAdapter = CustomRecyclerAdapter(arrayListOf())
    private val viewModel: PlanningListViewModel by lazy {
        ViewModelProvider(this).get(
            PlanningListViewModel::class.java
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.list.adapter = customRecyclerAdapter

        binding.addButton.setOnClickListener {
            val action = PlanningListFramgentDirections.toAddPlanningItem()
            view.findNavController().navigate(action)
        }

        viewModel.planningList.observe(viewLifecycleOwner) {
            binding.textHint.isVisible = it.isEmpty()
            customRecyclerAdapter.updateList(it)
        }
    }
}