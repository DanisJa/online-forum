package com.example.onlineforum.post

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    fun insertPost(post: Post)

    @Delete
    fun deletePost(post: Post)

    @Query("SELECT * FROM posts WHERE id = :id")
    fun getPostById(id: Int): Post

    @Query("SELECT * FROM posts ORDER BY id ASC")
    fun getAllPosts(): Flow<List<Post>>
}