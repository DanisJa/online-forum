package com.example.onlineforum.screens.category

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.onlineforum.category.Category
import com.example.onlineforum.category.CategoryViewModel

@Composable
fun CreateCategoryScreen(navController: NavController, viewModel: CategoryViewModel) {
    var name by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter text") },
            modifier = Modifier.fillMaxWidth()
        )

        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { navController.navigate("CategoryList") },
                modifier = Modifier.align(Alignment.BottomStart)
            ) {
                Text("BACK")
            }

            Button(
                onClick = {
                    viewModel.addCategory(Category(name = name))
                    navController.navigate("CategoryList")
                          },
                modifier = Modifier.align(Alignment.BottomEnd)
            ) {
                Text("CREATE")
            }
        }
    }
}
