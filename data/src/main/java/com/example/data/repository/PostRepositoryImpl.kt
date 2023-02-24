package com.example.data.repository

import com.example.data.source.PostService
import com.example.domain.repository.PostRepository

class PostRepositoryImpl(private val postService: PostService) : PostRepository {

    override suspend fun getAllPosts() =
        postService.getAllPosts().body().orEmpty()
}