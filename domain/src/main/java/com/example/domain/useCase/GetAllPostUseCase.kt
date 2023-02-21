package com.example.domain.useCase

import com.example.domain.repository.PostRepository

class GetAllPostUseCase(private val postRepository: PostRepository) {
    suspend operator fun invoke() = postRepository.getAllPosts()
}