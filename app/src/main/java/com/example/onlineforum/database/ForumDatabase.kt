package com.example.onlineforum.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.onlineforum.category.Category
import com.example.onlineforum.category.CategoryDao
import com.example.onlineforum.post.Post
import com.example.onlineforum.post.PostDao
import com.example.onlineforum.topic.Topic
import com.example.onlineforum.topic.TopicDao

@Database (entities = [Post::class, Topic::class, Category::class], version = 1, exportSchema =
false)
abstract class ForumDatabase(): RoomDatabase() {
    abstract fun postDao(): PostDao
    abstract fun topicDao(): TopicDao
    abstract fun categoryDao(): CategoryDao

    companion object{
        @Volatile
        private var INSTANCE: ForumDatabase? = null

        fun getDatabase(context: Context): ForumDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ForumDatabase::class.java,
                    "forum_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}