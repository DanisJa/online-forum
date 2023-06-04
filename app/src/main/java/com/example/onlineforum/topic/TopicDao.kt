package com.example.onlineforum.topic

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TopicDao  {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTopic(topic: Topic)

    @Delete
    fun deleteTopic(topic: Topic)

    @Query ("SELECT * FROM topics")
    fun getAllTopics(): Flow<List<Topic>>

    @Query ("SELECT * FROM topics WHERE id = :id")
    fun getTopicById(id: Int): Topic
}