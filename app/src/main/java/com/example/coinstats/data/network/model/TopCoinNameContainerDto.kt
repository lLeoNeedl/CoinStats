package com.example.coinstats.data.network.model

import com.google.gson.annotations.SerializedName

data class TopCoinNameContainerDto (

    @SerializedName("CoinInfo")
    val coinName: TopCoinNameDto? = null
)