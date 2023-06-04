package com.example.onlineforum.category

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CategoryCard (category: Category, viewModel: CategoryViewModel, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = category.name,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement
                .SpaceBetween) {
                Button(onClick = {navController.navigate("TopicList/${category.id}")}) {
                    Text("VIEW")
                }
                Button(onClick = { viewModel.deleteCategory(category) }) {
                    Text("DELETE")
                }
            }
        }
    }
}