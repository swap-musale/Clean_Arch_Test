package com.example.data.source

import com.example.domain.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface PostService {

    @GET("/posts")
    suspend fun getAllPosts(): Response<List<Post>>
}