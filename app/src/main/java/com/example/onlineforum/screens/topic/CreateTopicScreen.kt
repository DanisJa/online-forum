package com.example.onlineforum.screens.topic

import androidx.compose.foundation.layout.*

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.onlineforum.topic.Topic
import com.example.onlineforum.topic.TopicViewModel
import com.example.onlineforum.ui.theme.OnlineForumTheme

@Composable
fun CreateTopicScreen (navController: NavController, viewModel: TopicViewModel) {
    OnlineForumTheme {
        var name by remember { mutableStateOf("") }
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val arguments = navBackStackEntry?.arguments
        val categoryId = arguments?.getInt("categoryId") ?: 0

        Column(modifier = Modifier.padding(16.dp)) {
            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Enter text") },
                modifier = Modifier.fillMaxWidth()
            )

            Box(modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = { navController.navigate("TopicList/${categoryId}") },
                    modifier = Modifier.align(Alignment.BottomStart)
                ) {
                    Text("BACK")
                }

                Button(
                    onClick = {
                        viewModel.addTopic(Topic(name = name, categoryId = categoryId))
                        navController.navigate("TopicList/${categoryId}")
                  },
                    modifier = Modifier.align(Alignment.BottomEnd)
                ) {
                    Text("CREATE")
                }
            }
        }
    }
}