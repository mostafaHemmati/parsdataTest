package com.hemmati.parsdatapriject.presentation.show

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hemmati.parsdatapriject.domain.model.StatisticsEntity
import com.hemmati.parsdatapriject.domain.usecase.GetStatisticsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class StatisticsViewModel constructor(private val getStatisticsUseCase: GetStatisticsUseCase) :
    ViewModel() {
    val statisticsData = MutableLiveData<StatisticsEntity>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getStatisticsUseCase.insertStatistics(getEntityData())
            statisticsData.postValue(getStatisticsUseCase.getStatistics(1))
        }
    }


    private fun getEntityData(): StatisticsEntity {
        return StatisticsEntity(1, "2023", "1", "1", "1")
    }



    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }

    companion object {
        private val TAG = StatisticsViewModel::class.java.name
    }

}