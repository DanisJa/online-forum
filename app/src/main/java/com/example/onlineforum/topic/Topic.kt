package com.example.onlineforum.topic

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.onlineforum.category.Category

@Entity(tableName = "topics",
    foreignKeys = [ForeignKey(
        Category::class,
        ["id"],
        ["categoryId"],
        ForeignKey.CASCADE)
    ]
)
data class Topic(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val categoryId: Int,
    val name: String,
)
