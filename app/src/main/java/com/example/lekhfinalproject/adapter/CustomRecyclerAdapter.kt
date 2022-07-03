package com.example.lekhfinalproject.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lekhfinalproject.data.Planning
import com.example.lekhfinalproject.data.PlanningEntity
import com.example.lekhfinalproject.presenter.PlanningListFramgentDirections


class CustomRecyclerAdapter(
    private val plannings: ArrayList<Planning>
) : RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(com.example.lekhfinalproject.R.id.title)
        val itemDescription: TextView =
            itemView.findViewById(com.example.lekhfinalproject.R.id.description)
        val itemRestTime: TextView =
            itemView.findViewById(com.example.lekhfinalproject.R.id.rest_time)
        val itemDeadLine: TextView =
            itemView.findViewById(com.example.lekhfinalproject.R.id.deadline_time)
        val container: ViewGroup =
            itemView.findViewById(com.example.lekhfinalproject.R.id.container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            com.example.lekhfinalproject.R.layout.fragment_planning_list_item,
            parent,
            false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemTitle.text = plannings[position].title
        holder.itemDescription.text = plannings[position].description
        holder.itemRestTime.text = plannings[position].restTime
        holder.itemDeadLine.text = plannings[position].deadlineTime

        holder.container.setOnClickListener {
            val action = PlanningListFramgentDirections.toPlanningItem(plannings[position])
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return plannings.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<PlanningEntity>) {
        val updatedList = list.map {
            Planning(it.title, it.description, it.restTime, it.deadlineTime)
        }
        this.plannings.clear()
        this.plannings.addAll(updatedList)
        notifyDataSetChanged()
    }
}