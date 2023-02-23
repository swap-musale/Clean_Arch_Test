package com.example.cleanarchtest

import android.app.Application
import com.example.cleanarchtest.di.*
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CATApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.INFO)
            modules(
                ApolloNetworkModule,
                NetworkModule,
                UseCaseModule,
                ViewModelModule,
                RepositoryModule
            )
        }

    }

}