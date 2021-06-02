package com.hemmati.parsdatapriject.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "statistics_entity")
class StatisticsEntity(
    @PrimaryKey
    var userId: Int = 0,
    var viewer: String = "",
    var download: String = "",
    var product: String = "",
    var report: String = ""
)