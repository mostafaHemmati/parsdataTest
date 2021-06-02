package com.hemmati.parsdatapriject.domain.dataAccess.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hemmati.parsdatapriject.domain.model.StatisticsEntity
import org.jetbrains.annotations.NotNull

@Dao
interface StatisticsDao {

    @Query("select * from statistics_entity where userId= :id")
    suspend fun getById(@NotNull id: Int): StatisticsEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(@NotNull data: StatisticsEntity)

}