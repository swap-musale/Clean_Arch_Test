package com.example.cleanarchtest.di

import com.example.domain.model.PostUseCases
import com.example.domain.useCase.ApolloGetCountryUseCase
import com.example.domain.useCase.GetAllPostUseCase
import org.koin.dsl.module

val UseCaseModule = module {
    single { GetAllPostUseCase(postRepository = get()) }
    single { PostUseCases(getAllPostUseCase = get()) }

    single { ApolloGetCountryUseCase(apolloCountryRepository = get()) }
}