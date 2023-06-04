package com.example.onlineforum.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.onlineforum.post.Post
import com.example.onlineforum.post.PostList
import com.example.onlineforum.post.PostViewModel
import com.example.onlineforum.ui.theme.OnlineForumTheme

@Composable
fun PostListScreen(navController: NavController, viewModel: PostViewModel) {
    OnlineForumTheme {
        val posts: List<Post> by viewModel.allPosts.collectAsState(initial = emptyList())
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val arguments = navBackStackEntry?.arguments
        val topicId = arguments?.getInt("topicId") ?: 0
        val categoryId = arguments?.getInt("categoryId")

        PostList(posts, topicId, viewModel, navController)
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
        ) {
            Button(
                onClick = { navController.navigate("CreatePost/${topicId}") },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Text("CREATE POST")
            }
            Button(
                onClick = { navController.navigate("CategoryList") },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomStart)
            ) {
                Text("CATEGORIES")
            }
        }
    }
}
