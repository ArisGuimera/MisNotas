package com.cursokotlin.misnotas

import android.app.Application
import android.arch.persistence.room.Room
import com.cursokotlin.misnotas.Database.TasksDatabase

/**
 * Created by aristidesguimeraorozco on 21/10/17.
 */

class MisNotasApp: Application() {

    companion object {
        lateinit var database: TasksDatabase
    }

    override fun onCreate() {
        super.onCreate()
        MisNotasApp.database =  Room.databaseBuilder(this, TasksDatabase::class.java, "tasks-db").build()
    }
}