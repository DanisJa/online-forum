package com.example.onlineforum.category

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val name: String
)
