package com.example.domain.repository

import com.example.domain.model.Post

interface ApolloCountryRepository {
    suspend fun getCountries(): List<Post>
}