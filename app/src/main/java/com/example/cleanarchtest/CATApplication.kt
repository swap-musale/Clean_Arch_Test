package com.example.cleanarchtest

import android.app.Application
import com.example.cleanarchtest.di.NetworkModule
import com.example.cleanarchtest.di.RepositoryModule
import com.example.cleanarchtest.di.UseCaseModule
import com.example.cleanarchtest.di.ViewModelModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CATApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.INFO)
            modules(
                NetworkModule,
                UseCaseModule,
                ViewModelModule,
                RepositoryModule
            )
        }

    }

}