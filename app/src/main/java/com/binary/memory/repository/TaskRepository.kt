package com.binary.memory.repository

import com.binary.memory.base.DraculaRepository
import com.binary.memory.database.dao.TaskDao
import com.binary.memory.model.Task
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) : DraculaRepository {

    suspend fun insertTask(task: Task) {
        taskDao.insert(task)
    }

    suspend fun deleteTask(task: Task) {
        taskDao.delete(task)
    }

    suspend fun deleteAllTasks() {
        taskDao.deleteAll()
    }

    suspend fun updateTask(task: Task) {
        taskDao.update(task)
    }

    fun getTaskById(id: Int): Flow<Task>? {
        return taskDao.getTaskById(id)
    }

    fun getAllTasks(): Flow<List<Task>> {
        return taskDao.getAllTasks()
    }

}