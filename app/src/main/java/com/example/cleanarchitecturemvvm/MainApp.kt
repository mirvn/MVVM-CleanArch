package com.example.cleanarchitecturemvvm

import android.app.Application
import android.content.Context
import com.example.cleanarchitecturemvvm.di.moduleApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApp : Application() {
    private var instance: MainApp? = null
    fun getInstance(): MainApp? {
        return instance
    }

    fun getContext(): Context? {
        return instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidLogger()
            androidContext(this@MainApp)
            modules(moduleApp)
        }
    }
}
