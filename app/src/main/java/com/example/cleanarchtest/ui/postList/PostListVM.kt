package com.example.cleanarchtest.ui.postList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.PostUseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostListVM(private val postUseCases: PostUseCases) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.EmptyList)
    val state: StateFlow<UiState> = _uiState

    init {
        fetchAllPostFromNetwork()
    }

    private fun fetchAllPostFromNetwork() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = UiState.Loading
            val postList = postUseCases.getAllPostUseCase()
            _uiState.value = UiState.PostListState(data = postList)
        }
    }
}