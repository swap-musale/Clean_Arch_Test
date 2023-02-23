package com.example.domain.useCase

import com.example.domain.repository.CountryRepository

class GetCountryUseCase(private val countryRepository: CountryRepository) {
    suspend operator fun invoke() = countryRepository.getCountries()
}