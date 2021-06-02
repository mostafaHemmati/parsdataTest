package com.hemmati.parsdatapriject.domain.dataAccess.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hemmati.parsdatapriject.domain.model.StatisticsEntity

@Dao
interface StatisticsDao {

    @Query("select * from statistics_entity where userId= :id")
    suspend fun getById(id: Int): StatisticsEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: StatisticsEntity)

}