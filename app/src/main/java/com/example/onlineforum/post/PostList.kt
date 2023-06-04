package com.example.onlineforum.post

import android.app.Application
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PostList(posts: List<Post>, topicId: Int, viewModel: PostViewModel, navController: NavController) {
    val filteredPosts = remember(posts, topicId) {
        posts.filter { it.topicId == topicId }
    }

    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(items = filteredPosts) { post ->
            PostCard(post, viewModel, navController)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}