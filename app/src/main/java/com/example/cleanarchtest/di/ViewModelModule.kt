package com.example.cleanarchtest.di

import com.example.cleanarchtest.ui.postList.PostListVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel { PostListVM(postUseCases = get()) }
}