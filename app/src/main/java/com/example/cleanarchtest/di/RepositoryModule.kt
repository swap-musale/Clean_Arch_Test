package com.example.cleanarchtest.di

import com.example.data.repository.PostRepositoryImpl
import com.example.domain.repository.PostRepository
import org.koin.dsl.module

val RepositoryModule = module {
    single<PostRepository> { PostRepositoryImpl(get()) }
}