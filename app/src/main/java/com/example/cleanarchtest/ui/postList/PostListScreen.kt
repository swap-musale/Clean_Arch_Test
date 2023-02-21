package com.example.cleanarchtest.ui.postList

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cleanarchtest.util.UiState
import com.example.domain.model.Post

@Composable
fun PostListScreen(uiState: UiState<List<Post>>) {
    Column(modifier = Modifier.fillMaxSize()) {
        when (uiState) {
            is UiState.Loading -> {
                LoadingComponent()
            }
            is UiState.EmptyList -> {
                EmptyPostListComponent()
            }
            is UiState.Success -> {
                ShowPostListView(uiState.data)
            }
            is UiState.Error -> {
                Log.d("TAG", "PostListScreen: ${uiState.exception.localizedMessage}")
            }
        }
    }
}

@Composable
fun ShowPostListView(data: List<Post>) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(space = 8.dp)) {
        items(count = data.size) { index ->
            PostItemComponent(post = data[index])
        }
    }
}
