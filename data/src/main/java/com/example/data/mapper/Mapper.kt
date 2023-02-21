package com.example.data.mapper

import com.example.data.model.DPost
import com.example.domain.model.Post

fun Post.toDPost() = DPost(it, title, body)
fun DPost.toPost() = Post(it, title, body)