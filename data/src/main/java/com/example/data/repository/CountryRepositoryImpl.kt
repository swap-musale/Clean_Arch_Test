package com.example.data.repository

import com.apollographql.apollo3.ApolloClient
import com.example.data.CountriesQuery
import com.example.data.mapper.toPost
import com.example.domain.model.Post
import com.example.domain.repository.CountryRepository

class CountryRepositoryImpl(private val apolloClient: ApolloClient) : CountryRepository {

    override suspend fun getCountries(): List<Post> {
        return apolloClient.query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toPost() }
            .orEmpty()
    }
}