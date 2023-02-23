package com.example.cleanarchtest.di

import com.apollographql.apollo3.ApolloClient
import com.example.cleanarchtest.util.Constants
import org.koin.dsl.module

val ApolloNetworkModule = module {
    single { provideApolloClient() }
}

fun provideApolloClient(): ApolloClient {
    return ApolloClient.Builder()
        .serverUrl(Constants.GRAPH_QL_BASE_URL)
        .build()
}