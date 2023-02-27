package com.example.coinstats.data.network.model

import com.google.gson.annotations.SerializedName

data class TopCoinsListDto (

    @SerializedName("Data")
    val data: List<TopCoinNameContainerDto>? = null
)