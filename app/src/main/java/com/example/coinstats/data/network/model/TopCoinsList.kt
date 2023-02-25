package com.example.coinstats.data.network.model

import com.google.gson.annotations.SerializedName

data class TopCoinsList (

    @SerializedName("Data")
    val data: List<TopCoin>?
)