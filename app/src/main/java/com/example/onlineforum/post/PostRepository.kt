package com.example.onlineforum.post

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class PostRepository (private val postDao: PostDao) {
    val getAllPosts: Flow<List<Post>> = postDao.getAllPosts()

    suspend fun addPost(post: Post){
        withContext(Dispatchers.IO) {
            postDao.insertPost(post)
        }
    }

    suspend fun deletePost(post: Post){
        withContext(Dispatchers.IO) {
            postDao.deletePost(post)
        }
    }
}