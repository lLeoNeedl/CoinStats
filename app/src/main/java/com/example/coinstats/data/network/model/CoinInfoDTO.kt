package com.example.coinstats.data.network.model

import com.google.gson.annotations.SerializedName

data class CoinInfoDTO(

    @SerializedName("FROMSYMBOL")
    val fromSymbol: String?,

    @SerializedName("TOSYMBOL")
    val toSymbol: String?,

    @SerializedName("PRICE")
    val price: Double?,

    @SerializedName("LASTUPDATE")
    val lastUpdate: String?,

    @SerializedName("HIGHDAY")
    val highDay: Double?,

    @SerializedName("LOWDAY")
    val lowDay: Double?,

    @SerializedName("MKTCAP")
    val marketCap: Long?,

    @SerializedName("IMAGEURL")
    val imageUrl: String?
)