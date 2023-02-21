package com.example.cleanarchtest.ui.postList

import com.example.domain.model.Post

sealed class UiState {
    object Loading: UiState()
    object EmptyList: UiState()
    data class PostListState(val data: List<Post>) : UiState()
}