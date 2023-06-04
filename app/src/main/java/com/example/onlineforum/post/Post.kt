package com.example.onlineforum.post

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.onlineforum.topic.Topic

@Entity(tableName = "posts",
    foreignKeys = [ForeignKey(
        Topic::class,
        ["id"],
        ["topicId"],
        ForeignKey.CASCADE)
    ]
)
data class Post(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val topicId: Int,
    val author: String,
    val title: String,
    val content: String,
)
