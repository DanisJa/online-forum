package com.example.onlineforum.topic

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineforum.database.ForumDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TopicViewModel (application: Application): AndroidViewModel(application) {
    var allTopics: Flow<List<Topic>>
    private val repository: TopicRepository

    init {
        val topicDao = ForumDatabase.getDatabase(application).topicDao()
        repository = TopicRepository(topicDao)
        allTopics = repository.getAllTopics
    }

    fun addTopic(topic: Topic) {
        try{
            viewModelScope.launch {
                repository.addTopic(topic)
                Toast.makeText(getApplication(), "Topic created!", Toast.LENGTH_SHORT).show()
            }
        } catch(err: java.lang.Exception){
            Toast.makeText(getApplication(), "${err.message}", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteTopic(topic: Topic) {
        try {
            viewModelScope.launch {
                repository.deleteTopic(topic)
                Toast.makeText(getApplication(), "Successfully deleted!", Toast.LENGTH_SHORT)
                    .show()
            }
        } catch(err: java.lang.Exception){
            Toast.makeText(getApplication(), "${err.message}", Toast.LENGTH_SHORT).show()
        }
    }
}