package com.binary.memory.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 任务
 */
@Entity(tableName = "task_table")
data class Task(
    // 任务ID
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    // 任务标题
    var title: String = "",
    // 任务描述
    var description: String = "",
    // 创建日期
    var createDate: String = "",
    // 提醒日期
    var date: String = "",
    // 提醒时间
    var time: String = "",
    // 是否完成
    var isDone: Boolean = false,
    // 优先级
    var priority: Int = 0
)