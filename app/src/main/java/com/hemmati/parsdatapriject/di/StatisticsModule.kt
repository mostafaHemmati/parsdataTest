package com.hemmati.parsdatapriject.di

import com.hemmati.parsdatapriject.domain.dataAccess.local.StatisticsDao
import com.hemmati.parsdatapriject.domain.dataAccess.repository.GetStatisticRepositoryImpl
import com.hemmati.parsdatapriject.domain.dataAccess.repository.StatisticsRepository
import com.hemmati.parsdatapriject.domain.usecase.GetStatisticsUseCase
import com.hemmati.parsdatapriject.presentation.show.StatisticsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val StatisticsModule = module {

    viewModel { StatisticsViewModel(get()) }

    single { createGetStatisticsUseCase(get()) }

    single { createStatisticsRepository(get()) }
}

fun createStatisticsRepository(statisticsDao: StatisticsDao): StatisticsRepository {
    return GetStatisticRepositoryImpl(statisticsDao)
}

fun createGetStatisticsUseCase(statisticsRepository: StatisticsRepository): GetStatisticsUseCase {
    return GetStatisticsUseCase(statisticsRepository)
}