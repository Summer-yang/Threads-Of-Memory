package com.binary.memory.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * 闪卡
 */
@Parcelize
@Entity(tableName = "flashcards")
data class Flashcard(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    // 正面内容
    val front: String,
    // 背面内容
    val back: String,
    // 创建时间
    val createdTime: Long,
    // 所属闪卡组
    val flashGroupId: Int
) : Parcelable

