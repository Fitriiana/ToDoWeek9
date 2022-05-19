package com.ubaya.todo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @ColumnInfo(name = "title")
    var title:String,
    @ColumnInfo(name = "notes")
    var notes:String,
    @ColumnInfo(name="priority")
    var priority:Int,
    @ColumnInfo(name="is_done")
    var is_done:Int
//    Karena di SQLITE tidak ada boolean maka nilai true or false bisa di ganti dengan nilai integer 1 dan 0, sehingga hanya dapat menggunakan Int
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int = 0
}