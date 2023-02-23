package com.example.domain.repository

import com.example.domain.model.Post

interface CountryRepository {
    suspend fun getCountries(): List<Post>
}