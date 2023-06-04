package com.example.onlineforum.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.onlineforum.category.Category
import com.example.onlineforum.category.CategoryList
import com.example.onlineforum.category.CategoryViewModel

@Composable
fun CategoryListScreen(navController: NavController, viewModel: CategoryViewModel) {
    val categories: List<Category> by viewModel.allCategories.collectAsState(initial = emptyList())
    CategoryList(categories, viewModel, navController)
    Box(
        modifier = Modifier.padding(16.dp).fillMaxSize()
    ) {
        Button(onClick = {navController.navigate("CreateCategory")}, modifier = Modifier.padding(16
            .dp).align
            (Alignment
            .BottomEnd)) {
            Text("CREATE CATEGORY")
        }
    }
}