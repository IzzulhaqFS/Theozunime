package com.izzulhaqfs.theozunime

import android.app.Application
import com.izzulhaqfs.theozunime.core.di.databaseModule
import com.izzulhaqfs.theozunime.core.di.networkModule
import com.izzulhaqfs.theozunime.core.di.repositoryModule
import com.izzulhaqfs.theozunime.di.useCaseModule
import com.izzulhaqfs.theozunime.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                )
            )
        }
    }
}