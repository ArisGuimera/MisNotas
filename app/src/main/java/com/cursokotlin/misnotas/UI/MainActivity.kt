package com.cursokotlin.misnotas.UI

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.cursokotlin.misnotas.Database.TaskEntity
import com.cursokotlin.misnotas.MisNotasApp
import com.cursokotlin.misnotas.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: TasksAdapter
    lateinit var tasks: MutableList<TaskEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tasks = mutableListOf()
        getTasks()
        btnAddTask.setOnClickListener { addTask(TaskEntity(name = etTask.text.toString())) }
    }

    fun getTasks() {
        doAsync {
            tasks = MisNotasApp.database.taskDao().getAllTasks()
            uiThread {
                setUpRecyclerView(tasks)
            }
        }
    }

    fun addTask(task:TaskEntity){
        doAsync {
            val id = MisNotasApp.database.taskDao().addTask(task)
            val task = MisNotasApp.database.taskDao().getTaskById(id)
            uiThread {
                tasks.add(task[0])
                adapter.notifyItemInserted(tasks.size)
            }
        }
    }

    fun setUpRecyclerView(tasks: List<TaskEntity>) {
        adapter = TasksAdapter()
        adapter.TasksAdapter(tasks)
        recyclerView = findViewById(R.id.rvTask)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
