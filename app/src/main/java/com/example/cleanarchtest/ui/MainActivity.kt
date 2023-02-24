package com.example.cleanarchtest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.cleanarchtest.ui.postList.PostListScreen
import com.example.cleanarchtest.ui.postList.PostListVM
import com.example.cleanarchtest.ui.theme.CleanArchTestTheme
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val uiState by getViewModel<PostListVM>().state.collectAsState()
                    PostListScreen(uiState = uiState)
                }
            }
        }
    }
}