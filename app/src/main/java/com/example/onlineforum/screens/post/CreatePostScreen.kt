package com.example.onlineforum.screens.post

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
import com.example.onlineforum.post.Post
import com.example.onlineforum.post.PostViewModel
import com.example.onlineforum.ui.theme.OnlineForumTheme

@Composable
fun CreatePostScreen (navController: NavController, viewModel: PostViewModel) {
    OnlineForumTheme {
        var author by remember { mutableStateOf("") }
        var content by remember { mutableStateOf("") }
        var title by remember { mutableStateOf("") }
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val arguments = navBackStackEntry?.arguments
        val topicId = arguments?.getInt("topicId") ?: 0

        Column(modifier = Modifier.padding(16.dp)) {
            TextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Enter title") },
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            )
            TextField(
                value = content,
                onValueChange = { content = it },
                label = { Text("Enter content") },
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            )
            TextField(
                value = author,
                onValueChange = { author = it },
                label = { Text("Enter your name") },
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            )

            Box(modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = { navController.navigate("PostList/${topicId}") },
                    modifier = Modifier.align(Alignment.BottomStart)
                ) {
                    Text("BACK")
                }

                Button(
                    onClick = {
                            viewModel.addPost(Post(author = author, content = content, title =
                            title, topicId = topicId))
                        navController.navigate("PostList/${topicId}")
                    },
                    modifier = Modifier.align(Alignment.BottomEnd)
                ) {
                    Text("CREATE")
                }
            }
        }
    }
}