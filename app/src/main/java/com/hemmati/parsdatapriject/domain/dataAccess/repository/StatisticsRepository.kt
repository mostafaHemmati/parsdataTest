package com.hemmati.parsdatapriject.domain.dataAccess.repository

import com.hemmati.parsdatapriject.domain.dataAccess.local.StatisticsDao
import com.hemmati.parsdatapriject.domain.model.StatisticsEntity

interface StatisticsRepository {

    suspend fun getStatistics(id: Int): StatisticsEntity
    suspend fun insertStatistics(statisticsEntity: StatisticsEntity)
}

class GetStatisticRepositoryImpl(private val statisticsDao: StatisticsDao) : StatisticsRepository {
    override suspend fun getStatistics(id: Int): StatisticsEntity {
        return statisticsDao.getById(id)
    }

    override suspend fun insertStatistics(statisticsEntity: StatisticsEntity) {
        statisticsDao.insert(statisticsEntity)
    }


}