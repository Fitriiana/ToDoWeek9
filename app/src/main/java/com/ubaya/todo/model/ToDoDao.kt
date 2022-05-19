package com.ubaya.todo.model

import androidx.room.*

@Dao
interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg todo:Todo)
    //    vararg digunakan untuk membuat todo yang banyak
//    suspend berfungsi untuk memberitau bahwa fungsi itu bisa pause


    @Query("SELECT * FROM todo WHERE is_done=:is_done ORDER BY priority DESC")
    suspend fun selectAllTodo(is_done: Int): List<Todo>

    @Query("SELECT * FROM todo WHERE uuid= :id ")
//    nama parameter harus sama
    suspend fun selectTodo(id:Int): Todo

    @Query("UPDATE todo SET title=:title, notes=:notes, priority=:priority WHERE uuid = :id")
    suspend fun update(title:String, notes:String, priority:Int, id:Int)

//    HOMEWORK
    @Query("UPDATE todo SET is_done=:is_done WHERE uuid=:id")
    suspend fun update(id:Int, is_done:Int)

    @Delete
    suspend fun deleteTodo(todo:Todo)
}