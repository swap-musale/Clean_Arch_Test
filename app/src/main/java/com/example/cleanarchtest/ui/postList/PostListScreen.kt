package com.example.cleanarchtest.ui.postList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.model.Post
import org.koin.androidx.compose.getViewModel

@Composable
fun PostListScreen(viewModel: PostListVM = getViewModel()) {

    Column(modifier = Modifier.fillMaxSize()) {
        when (val uiState = viewModel.state.collectAsState().value) {
            is UiState.Loading -> {
                LoadingComponent()
            }
            is UiState.EmptyList -> {
                EmptyPostListComponent()
            }
            is UiState.PostListState -> {
                ShowPostListView(uiState.data)
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
