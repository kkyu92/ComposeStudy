package com.example.composestudy.data

import androidx.room.*
import com.example.composestudy.data.models.ToDoTask
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface ToDoDao {

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllTasks(): Single<List<ToDoTask>>

    @Query("SELECT * FROM todo_table WHERE id=:taskId")
    fun getSelectedTask(taskId: Int): Single<ToDoTask>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addTask(toDoTask: ToDoTask): Completable

    @Update
    fun updateTask(toDoTask: ToDoTask): Completable

    @Delete
    fun deleteTask(toDoTask: ToDoTask): Completable

    @Query("DELETE FROM todo_table")
    fun deleteAllTasks(): Completable

    @Query("SELECT * FROM todo_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Single<List<ToDoTask>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): Single<List<ToDoTask>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Single<List<ToDoTask>>
}