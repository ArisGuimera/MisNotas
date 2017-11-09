package com.cursokotlin.misnotas.UI

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Checkable
import android.widget.TextView
import com.cursokotlin.misnotas.Database.TaskEntity
import com.cursokotlin.misnotas.R

/**
 * Created by aristidesguimeraorozco on 21/10/17.
 */
class TasksAdapter(
        val tasks: List<TaskEntity>,
        val checkTask: (TaskEntity) -> Unit,
        val deleteTask: (TaskEntity) -> Unit) : RecyclerView.Adapter<TasksAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = tasks[position]
        holder.bind(item, checkTask, deleteTask)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_task, parent, false))
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTask = view.findViewById<TextView>(R.id.tvTask)
        val cbIsDone = view.findViewById<CheckBox>(R.id.cbIsDone)

        fun bind(task: TaskEntity, checkTask: (TaskEntity) -> Unit, deleteTask: (TaskEntity) -> Unit) {
            tvTask.text = task.name
            cbIsDone.isChecked = task.isDone
            cbIsDone.setOnClickListener{checkTask(task)}
            itemView.setOnClickListener { deleteTask(task) }
        }
    }
}