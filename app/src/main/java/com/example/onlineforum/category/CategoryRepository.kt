package com.example.onlineforum.category

import kotlinx.coroutines.flow.Flow

class CategoryRepository(private val categoryDao: CategoryDao) {
    val getAllCategories: Flow<List<Category>> = categoryDao.getAllCategories()

    suspend fun addCategory(category: Category) {
        categoryDao.insertCategory(category)
    }

    suspend fun deleteCategory(category: Category){
        categoryDao.deleteCategory(category)
    }
}