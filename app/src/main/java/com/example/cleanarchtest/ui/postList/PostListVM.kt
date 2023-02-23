package com.example.cleanarchtest.ui.postList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchtest.util.UiState
import com.example.domain.model.Post
import com.example.domain.model.PostUseCases
import com.example.domain.useCase.ApolloGetCountryUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostListVM(
    private val postUseCases: PostUseCases,
    private val countryUseCase: ApolloGetCountryUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Post>>>(UiState.EmptyList)
    val state: StateFlow<UiState<List<Post>>> = _uiState

    init {
        fetchAllPostFromNetwork()
    }

    private fun fetchAllPostFromNetwork() {
        viewModelScope.launch(dispatcher) {
            _uiState.value = UiState.Loading
//            val postList = postUseCases.getAllPostUseCase()
            val postList = countryUseCase()
            _uiState.value = UiState.Success(data = postList)
        }
    }
}