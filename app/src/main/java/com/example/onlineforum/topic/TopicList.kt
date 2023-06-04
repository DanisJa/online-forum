package com.example.onlineforum.topic

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.onlineforum.post.Post
import com.example.onlineforum.post.PostCard

@Composable
fun TopicList(topics: List<Topic>, categoryId: Int, viewModel: TopicViewModel, navController: NavController ) {
    val filteredTopics = topics.filter { it.categoryId == categoryId }

    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(items = filteredTopics) { topic ->
            TopicCard(topic, navController, viewModel)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}