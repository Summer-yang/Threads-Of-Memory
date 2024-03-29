package com.binary.memory.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.binary.memory.base.DraculaViewModel
import com.binary.memory.constants.Constants
import com.binary.memory.model.Task
import com.binary.memory.repository.TaskRepository
import com.binary.memory.utils.DateUtils
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : DraculaViewModel() {

    private val _task = MutableLiveData<Task>()
    val task: LiveData<Task> = _task

    private val _taskList = MutableLiveData<List<Task>>()
    val taskList: LiveData<List<Task>> = _taskList

    private var priority = Constants.Priority.LOW

    fun setPriority(priority: Constants.Priority) {
        this.priority = priority
    }


    fun insertTask(title: String?, content: String?) {
        if (title.isNullOrEmpty() || content.isNullOrEmpty()) return
        viewModelScope.launch {
            repository.insertTask(
                Task(
                    title = title,
                    description = content,
                    date = DateUtils.getTodayDate(),
                    priority = priority.getOrdinal()
                )
            )
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            repository.deleteTask(task)
        }
    }

    fun deleteAllTasks() {
        viewModelScope.launch {
            repository.deleteAllTasks()
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            repository.updateTask(task)
        }
    }

    fun getTaskById(id: Int) {
        viewModelScope.launch {
            repository.getTaskById(id)?.collect {
                _task.value = it
            }
        }
    }

    fun getAllTasks() {
        viewModelScope.launch {
            repository.getAllTasks().collect {
                _taskList.value = it
            }
        }
    }

    fun getTasksByDate(date: String) {
        viewModelScope.launch {
            repository.getTasksByDate(date).collect {
                _taskList.value = it
            }
        }
    }

}

class TaskViewModelFactory(private val repository: TaskRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TaskViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}