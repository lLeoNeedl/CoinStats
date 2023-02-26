package com.example.coinstats.domain.entities

data class TopCoin(

    val fromSymbol: String,

    val toSymbol: String,

    val price: Double,

    val lastUpdate: String,

    val highDay: Double,

    val lowDay: Double,

    val marketCap: Long,

    val imageUrl: String
) {

}