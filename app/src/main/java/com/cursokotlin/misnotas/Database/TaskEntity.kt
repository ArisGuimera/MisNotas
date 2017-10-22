package com.cursokotlin.misnotas.Database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by aristidesguimeraorozco on 21/10/17.
 */
@Entity(tableName = "task_entity")
data class TaskEntity (
        @PrimaryKey(autoGenerate = true)
        var id:Int = 0,
        var name:String = "",
        var isDone:Boolean = false
)