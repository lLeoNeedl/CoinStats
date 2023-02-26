package com.example.coinstats.data.network.model

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class JsonContainerDto (

    @SerializedName("RAW")
    val json: JsonObject? = null
)