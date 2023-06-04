package com.example.onlineforum.topic

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TopicCard (topic: Topic, navController: NavController, viewModel: TopicViewModel) {
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
                text = topic.name,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement
                .SpaceBetween) {
                Button(onClick = {navController.navigate("PostList/${topic.id}")}) {
                    Text("VIEW")
                }
                Button(onClick = {viewModel.deleteTopic(topic)}) {
                    Text("DELETE")
                }
            }
        }
    }
}