package com.example.coinstats.data.network.model

import com.google.gson.annotations.SerializedName

data class CoinDto(

    @SerializedName("FROMSYMBOL")
    val fromSymbol: String? = null,

    @SerializedName("TOSYMBOL")
    val toSymbol: String? = null,

    @SerializedName("PRICE")
    val price: Double? = null,

    @SerializedName("LASTUPDATE")
    val lastUpdate: Long? = null,

    @SerializedName("HIGHDAY")
    val highDay: Double? = null,

    @SerializedName("LOWDAY")
    val lowDay: Double? = null,

    @SerializedName("MKTCAP")
    val marketCap: Long? = null,

    @SerializedName("IMAGEURL")
    val imageUrl: String? = null
)