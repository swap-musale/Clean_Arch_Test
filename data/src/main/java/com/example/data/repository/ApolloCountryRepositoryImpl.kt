package com.example.data.repository

import com.apollographql.apollo3.ApolloClient
import com.example.data.CountriesQuery
import com.example.data.mapper.toPost
import com.example.domain.model.Post
import com.example.domain.repository.ApolloCountryRepository

class ApolloCountryRepositoryImpl(private val apolloClient: ApolloClient) :
    ApolloCountryRepository {

    override suspend fun getCountries(): List<Post> {
        return try {
            apolloClient.query(CountriesQuery())
                .execute()
                .data
                ?.countries.orEmpty()
                .map { it.toPost() }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}