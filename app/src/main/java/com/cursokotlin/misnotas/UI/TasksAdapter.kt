package com.cursokotlin.misnotas.UI

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.cursokotlin.misnotas.Database.TaskEntity
import com.cursokotlin.misnotas.R

/**
 * Created by aristidesguimeraorozco on 21/10/17.
 */
class TasksAdapter : RecyclerView.Adapter<TasksAdapter.ViewHolder>() {

    var tasks: List<TaskEntity> = ArrayList()

    fun TasksAdapter(tasks: List<TaskEntity>) {
        this.tasks = tasks
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = tasks[position]
        holder.bind(item)
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

        fun bind(task: TaskEntity) {
            tvTask.text = task.name
            cbIsDone
            itemView.setOnClickListener(View.OnClickListener {})
        }
    }
}