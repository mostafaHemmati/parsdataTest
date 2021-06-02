package com.hemmati.parsdatapriject.domain.usecase

import com.hemmati.parsdatapriject.domain.dataAccess.repository.StatisticsRepository
import com.hemmati.parsdatapriject.domain.model.StatisticsEntity

class GetStatisticsUseCase constructor(
    private val statisticsRepository: StatisticsRepository
) {

    suspend fun getStatistics(id: Int): StatisticsEntity {
        return statisticsRepository.getStatistics(id)
    }

    suspend fun insertStatistics(statisticsEntity: StatisticsEntity) {
        statisticsRepository.insertStatistics(statisticsEntity)
    }

}