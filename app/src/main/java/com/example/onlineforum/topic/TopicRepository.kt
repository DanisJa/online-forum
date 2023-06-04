package com.example.onlineforum.topic

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class TopicRepository (private val topicDao: TopicDao) {
    val getAllTopics: Flow<List<Topic>> = topicDao.getAllTopics()

    suspend fun addTopic(topic: Topic){
        withContext(Dispatchers.IO) {
            topicDao.insertTopic(topic)
        }
    }

    suspend fun deleteTopic(topic: Topic){
        withContext(Dispatchers.IO) {
            topicDao.deleteTopic(topic)
        }
    }
}