package com.cursokotlin.misnotas.Database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by aristidesguimeraorozco on 21/10/17.
 */
@Database(entities = arrayOf(TaskEntity::class), version = 1)
abstract class TasksDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}