package com.hemmati.parsdatapriject

import android.app.Application
import com.hemmati.parsdatapriject.di.NetworkModule
import com.hemmati.parsdatapriject.di.PostModule
import com.hemmati.parsdatapriject.di.StatisticsModule
import com.hemmati.parsdatapriject.di.localModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            androidFileProperties()
            modules(getModulesList())
        }
    }

    private fun getModulesList(): List<Module> {
        return listOf(NetworkModule, PostModule, localModule,StatisticsModule)
    }
}