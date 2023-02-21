package com.example.cleanarchtest.di

import com.example.cleanarchtest.util.Constants
import com.example.data.BuildConfig
import com.example.data.source.PostService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val NetworkModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    factory { providePostService(get()) }
}

private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
        .setLevel(HttpLoggingInterceptor.Level.BODY)
}

fun provideOkHttpClient() = OkHttpClient
    .Builder()
    .also { builder ->
        if (BuildConfig.DEBUG) builder.addInterceptor(provideLoggingInterceptor())
    }
    .build()

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun providePostService(retrofit: Retrofit): PostService =
    retrofit.create(PostService::class.java)
