package com.example.onlineforum.category

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CategoryList(categories: List<Category>, viewModel: CategoryViewModel, navController: NavController) {
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(items = categories) {category ->
            CategoryCard(category, viewModel, navController)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}