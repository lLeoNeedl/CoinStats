package com.example.coinstats.data.network.model

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class TopCoin (

    @SerializedName("RAW")
    val json: JsonObject?
)