package com.example.coinstats.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "top_coins_by_market_cap")
data class TopCoinDbModel (

    @PrimaryKey
    val fromSymbol: String,

    val toSymbol: String,

    val price: Double,

    val lastUpdate: Long,

    val highDay: Double,

    val lowDay: Double,

    val marketCap: Long,

    val imageUrl: String
)