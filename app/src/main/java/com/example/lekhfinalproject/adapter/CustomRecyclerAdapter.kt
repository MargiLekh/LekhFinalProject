package com.example.lekhfinalproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lekhfinalproject.R
import com.example.lekhfinalproject.data.Planning

class CustomRecyclerAdapter(private val plannings: List<Planning>) : RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemTitle: TextView = itemView.findViewById(R.id.title)
        val itemDescription: TextView = itemView.findViewById(R.id.description)
        val itemRestTime: TextView = itemView.findViewById(R.id.rest_time)
        val itemDeadLine: TextView = itemView.findViewById(R.id.deadline_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_planning_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemTitle.text = plannings[position].title
        holder.itemDescription.text = plannings[position].description
        holder.itemRestTime.text = plannings[position].restTime
        holder.itemDeadLine.text = plannings[position].deadlineTime
    }

    override fun getItemCount(): Int {
        return plannings.size
    }


}