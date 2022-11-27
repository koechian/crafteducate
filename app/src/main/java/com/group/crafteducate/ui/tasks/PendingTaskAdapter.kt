package com.group.crafteducate.ui.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.group.crafteducate.R

class PendingTaskAdapter(private val taskList: ArrayList<TaskData>) :RecyclerView.Adapter<PendingTaskAdapter.ViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val pendingitemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_pending,parent,false)

        return ViewHolder(pendingitemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = taskList[position]

        holder.pendingTitle.text = current.Title
        holder.pendingDue.text = current.Due
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val pendingTitle : TextView = itemView.findViewById(R.id.pendingTitle)
        val pendingDue : TextView = itemView.findViewById(R.id.pendingDue)



    }

}