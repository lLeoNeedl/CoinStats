package com.example.coinstats.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("favourite_coins")
data class FavouriteCoinsDbModel(

    @PrimaryKey
    val fromSymbol: String,

    val toSymbol: String,

    val price: Double,

    val lastUpdate: String,

    val highDay: Double,

    val lowDay: Double,

    val marketCap: Long,

    val imageUrl: String
)