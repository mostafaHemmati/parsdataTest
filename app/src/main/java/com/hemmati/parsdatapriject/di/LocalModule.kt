package com.hemmati.parsdatapriject.di

import androidx.room.Room
import com.hemmati.parsdatapriject.BuildConfig
import com.hemmati.parsdatapriject.domain.dataAccess.local.CoreDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localModule = module {

    single {
        Room.databaseBuilder(androidApplication(), CoreDatabase::class.java, BuildConfig.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }


    factory { get<CoreDatabase>().statisticsDao() }
}