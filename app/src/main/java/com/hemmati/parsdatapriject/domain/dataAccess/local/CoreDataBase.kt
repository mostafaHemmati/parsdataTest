package com.hemmati.parsdatapriject.domain.dataAccess.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hemmati.parsdatapriject.domain.model.StatisticsEntity

@Database(
    entities = [StatisticsEntity::class],
    version = 1,
    exportSchema = true
)
abstract class CoreDatabase : RoomDatabase() {
    abstract fun statisticsDao(): StatisticsDao
}