package com.example.cleanarchtest.di

import com.example.data.repository.CountryRepositoryImpl
import com.example.data.repository.PostRepositoryImpl
import com.example.domain.repository.CountryRepository
import com.example.domain.repository.PostRepository
import org.koin.dsl.module

val RepositoryModule = module {
    single<PostRepository> { PostRepositoryImpl(postService = get()) }
    single<CountryRepository> { CountryRepositoryImpl(apolloClient = get()) }
}