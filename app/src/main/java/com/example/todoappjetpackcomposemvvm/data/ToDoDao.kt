package com.example.todoappjetpackcomposemvvm.data

import androidx.room.*
import com.example.todoappjetpackcomposemvvm.data.models.ToDoTask
import kotlinx.coroutines.flow.Flow


@Dao
interface ToDoDao {

    @Query("select * from todo_table order by id asc")
    fun getAllTasks(): Flow<List<ToDoTask>>

    @Query("select * from todo_table where id = :taskId")
    fun getSelectedTask(taskId: Int): Flow<ToDoTask>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(toDoTask: ToDoTask)

    @Update
    suspend fun updateTask(toDoTask: ToDoTask)

    @Delete
    suspend fun deleteTask(toDoTask: ToDoTask)

    @Query("delete from todo_table")
    suspend fun deleteAllTasks()

    @Query("select * from todo_table where title like :searchQuery or description like :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>>

    @Query(
        """
        SELECT * FROM todo_table ORDER BY
    CASE
        WHEN priority LIKE 'L%' THEN 1
        WHEN priority LIKE 'M%' THEN 2
        WHEN priority LIKE 'H%' THEN 3
    END
    """
    )
    fun sortByLowPriority(): Flow<List<ToDoTask>>

    @Query(
        """
        SELECT * FROM todo_table ORDER BY
    CASE
        WHEN priority LIKE 'H%' THEN 1
        WHEN priority LIKE 'M%' THEN 2
        WHEN priority LIKE 'L%' THEN 3
    END
    """
    )
    fun sortByHighPriority(): Flow<List<ToDoTask>>

}