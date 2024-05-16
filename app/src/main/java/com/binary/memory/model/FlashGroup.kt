package com.binary.memory.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flash_group")
data class FlashGroup(
    // 主键
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    // 闪卡组标题
    val flashGroupTitle: String,
    // 闪卡组描述
    val flashGroupDescription: String
)