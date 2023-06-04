package com.example.onlineforum.post

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineforum.database.ForumDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PostViewModel (application: Application): AndroidViewModel(application) {
    var allPosts: Flow<List<Post>>
    private val repository: PostRepository

    init {
        val postDao = ForumDatabase.getDatabase(application).postDao()
        repository = PostRepository(postDao)
        allPosts = repository.getAllPosts
    }

    fun addPost(post: Post){
        try{
            viewModelScope.launch {
                    repository.addPost(post)
                    Toast.makeText(getApplication(), "Post created", Toast.LENGTH_SHORT).show()
            }
        } catch(err: java.lang.Exception) {
            Toast.makeText(getApplication(), err.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun deletePost(post: Post){
        try{
            viewModelScope.launch {
                repository.deletePost(post)
            }
        } catch (err: java.lang.Exception) {
            Toast.makeText(getApplication(), "$err.message", Toast.LENGTH_SHORT).show()
        }
    }
}