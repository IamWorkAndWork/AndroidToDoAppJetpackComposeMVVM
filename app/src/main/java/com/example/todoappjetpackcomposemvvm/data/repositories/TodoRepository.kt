package com.example.todoappjetpackcomposemvvm.data.repositories

import com.example.todoappjetpackcomposemvvm.data.ToDoDao
import com.example.todoappjetpackcomposemvvm.data.models.ToDoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@ViewModelScoped
class TodoRepository @Inject constructor(
    private val toDoDao: ToDoDao
) {

    val getAllTasks: Flow<List<ToDoTask>>
        get() = toDoDao.getAllTasks()

    val sortByLowPriority: Flow<List<ToDoTask>>
        get() = toDoDao.sortByLowPriority()

    val sortByHighPriority: Flow<List<ToDoTask>>
        get() = toDoDao.sortByHighPriority()

    suspend fun getSelectedTask(taskId: Int): Flow<ToDoTask> {
        return toDoDao.getSelectedTask(taskId = taskId)
    }

    suspend fun addTask(toDoTask: ToDoTask) {
        toDoDao.addTask(toDoTask = toDoTask)
    }

    suspend fun updateTask(toDoTask: ToDoTask) {
        return toDoDao.updateTask(toDoTask = toDoTask)
    }

    suspend fun deleteTask(toDoTask: ToDoTask) {
        return toDoDao.deleteTask(toDoTask = toDoTask)
    }

    suspend fun deleteAllTasks() {
        return toDoDao.deleteAllTasks()
    }

    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>> {
        return toDoDao.searchDatabase(searchQuery = searchQuery)
    }

}