package com.example.domain.useCase

import com.example.domain.repository.ApolloCountryRepository

class ApolloGetCountryUseCase(private val apolloCountryRepository: ApolloCountryRepository) {
    suspend operator fun invoke() = apolloCountryRepository.getCountries()
}