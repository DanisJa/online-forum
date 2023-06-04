package com.example.onlineforum.category

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineforum.database.ForumDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CategoryViewModel (application: Application): AndroidViewModel(application) {
    var allCategories: Flow<List<Category>>
    private val repository: CategoryRepository

    init {
        val categoryDao = ForumDatabase.getDatabase(application).categoryDao()
        repository = CategoryRepository(categoryDao)
        allCategories = repository.getAllCategories
    }

    fun addCategory(category: Category) {
        try{
            viewModelScope.launch {
                repository.addCategory(category)
                Toast.makeText(getApplication(), "Category created!", Toast.LENGTH_SHORT).show()
            }
        } catch(err: java.lang.Exception){
            Toast.makeText(getApplication(), err.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteCategory(category: Category) {
        try{
            viewModelScope.launch {
                repository.deleteCategory(category)
                Toast.makeText(getApplication(), "Category created", Toast.LENGTH_SHORT).show()
            }
        } catch(err: java.lang.Exception) {
            Toast.makeText(getApplication(), err.message, Toast.LENGTH_SHORT).show()
        }
    }
}