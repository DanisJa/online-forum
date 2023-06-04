package com.example.onlineforum.screens

import android.app.Application
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.onlineforum.topic.Topic
import com.example.onlineforum.topic.TopicList
import com.example.onlineforum.topic.TopicViewModel
import com.example.onlineforum.ui.theme.OnlineForumTheme

@Composable
fun TopicListScreen(navController: NavController, viewModel: TopicViewModel) {
    OnlineForumTheme {
        val topics: List<Topic> by viewModel.allTopics.collectAsState(initial = emptyList())
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val arguments = navBackStackEntry?.arguments
        val categoryId = arguments?.getInt("categoryId") ?: 0

        TopicList(topics, categoryId, viewModel, navController)
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
        ) {
            Button(
                onClick = { navController.navigate("CategoryList") },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomStart)
            ) {
                Text("BACK")
            }
            Button(
                onClick = { navController.navigate("CreateTopic/${categoryId}") },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Text("CREATE TOPIC")
            }
        }
    }
}