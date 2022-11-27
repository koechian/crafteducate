package com.group.crafteducate.ui.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.group.crafteducate.R

class CompletedTaskAdapter(private val taskList: ArrayList<TaskData>) :RecyclerView.Adapter<CompletedTaskAdapter.ViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val completeditemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_completed,parent,false)

        return ViewHolder(completeditemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = taskList[position]

        holder.completedTitle.text = current.Title
        holder.completedDue.text = current.Due
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val completedTitle : TextView = itemView.findViewById(R.id.completedTitle)
        val completedDue : TextView = itemView.findViewById(R.id.completedDue)

    }

}