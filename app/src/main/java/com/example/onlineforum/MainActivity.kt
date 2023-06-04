package com.example.onlineforum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.onlineforum.category.CategoryViewModel
import com.example.onlineforum.post.PostViewModel
import com.example.onlineforum.screens.CategoryListScreen
import com.example.onlineforum.screens.PostListScreen
import com.example.onlineforum.screens.TopicListScreen
import com.example.onlineforum.screens.category.CreateCategoryScreen
import com.example.onlineforum.screens.post.CreatePostScreen
import com.example.onlineforum.screens.topic.CreateTopicScreen
import com.example.onlineforum.topic.TopicViewModel
import com.example.onlineforum.ui.theme.OnlineForumTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnlineForumTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "CategoryList"){
                    composable("CategoryList"){
                        CategoryListScreen(navController = navController, CategoryViewModel(application))
                    }
                    composable("CreateCategory"){
                        CreateCategoryScreen(navController = navController, CategoryViewModel(application))
                    }
                    composable("TopicList/{categoryId}", arguments = listOf(navArgument
                        ("categoryId") {type = NavType.IntType})
                    ){
                        TopicListScreen(navController, TopicViewModel(application))
                    }
                    composable("CreateTopic/{categoryId}", arguments = listOf(navArgument
                        ("categoryId") {type = NavType.IntType})
                    ){
                        CreateTopicScreen(navController = navController, viewModel = TopicViewModel(application))
                    }
                    composable("PostList/{topicId}", arguments = listOf(navArgument("topicId")
                    {type = NavType.IntType}))
                    {
                        PostListScreen(navController = navController, viewModel = PostViewModel(application))
                    }
                    composable("CreatePost/{topicId}", arguments = listOf(navArgument
                        ("topicId") {type = NavType.IntType}))
                    {
                        CreatePostScreen(navController = navController, viewModel = PostViewModel(application))
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OnlineForumTheme {
        Greeting("Android")
    }
}