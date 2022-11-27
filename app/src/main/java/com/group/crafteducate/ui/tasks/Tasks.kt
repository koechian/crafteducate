package com.group.crafteducate.ui.tasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.group.crafteducate.MainActivity
import com.group.crafteducate.R
import com.group.crafteducate.databinding.TasksBinding

class Tasks : AppCompatActivity() {

    private lateinit var completedRecyclerView: RecyclerView
    private lateinit var pendingRecyclerView: RecyclerView

    private lateinit var pendingtaskList:ArrayList<TaskData>
    private lateinit var completedtaskList:ArrayList<TaskData>


    private lateinit var pendingTitle: Array<String>
    private lateinit var pendingDue: Array<String>

    private lateinit var completedTitle: Array<String>
    private lateinit var completedDue: Array<String>

    private lateinit var binding: TasksBinding
    private lateinit var firebase: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
//        hide title bar
        supportActionBar?.hide()

        firebase = FirebaseAuth.getInstance()
        binding = TasksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backbutton.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        completedTitle = resources.getStringArray(R.array.completed_task_titles)
        completedDue= resources.getStringArray(R.array.completed_due_dates)

        pendingTitle= resources.getStringArray(R.array.pending_task_titles)
        pendingDue= resources.getStringArray(R.array.pending_due_dates)

        completedRecyclerView = findViewById(R.id.completedRecycler)
        completedRecyclerView.layoutManager = LinearLayoutManager(this)
        completedRecyclerView.setHasFixedSize(true)

        pendingRecyclerView = findViewById(R.id.pendingRecycler)
        pendingRecyclerView.layoutManager = LinearLayoutManager(this)
        pendingRecyclerView.setHasFixedSize(true)


        pendingtaskList = arrayListOf<TaskData>()
        completedtaskList = arrayListOf<TaskData>()

        getData()
    }

    private fun getData() {
        for (i in pendingTitle.indices){
            val pendingtasks=TaskData(pendingTitle[i],pendingDue[i])
            pendingtaskList.add(pendingtasks)
        }
//            Log.e("Data",pendingtaskList.toString())
        for(i in completedTitle.indices){
            val completedTasks = TaskData(completedTitle[i],completedDue[i])
            completedtaskList.add(completedTasks)
        }
        pendingRecyclerView.adapter = PendingTaskAdapter(pendingtaskList)
        completedRecyclerView.adapter = CompletedTaskAdapter(completedtaskList)

    }
}