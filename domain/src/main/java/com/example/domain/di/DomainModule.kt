package com.example.domain.di

import com.example.domain.model.PostUseCases
import com.example.domain.useCase.GetAllPostUseCase
import org.koin.dsl.module

val DomainModule = module {
    single { GetAllPostUseCase(get()) }
    single { PostUseCases(get()) }
}