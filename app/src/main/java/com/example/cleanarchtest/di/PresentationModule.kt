package com.example.cleanarchtest.di

import com.example.cleanarchtest.ui.postList.PostListVM
import org.koin.dsl.module

val PresentationModule = module {
    single { PostListVM(get()) }
}