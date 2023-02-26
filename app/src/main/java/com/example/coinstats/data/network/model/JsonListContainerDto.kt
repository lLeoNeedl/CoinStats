package com.example.coinstats.data.network.model

import com.google.gson.annotations.SerializedName

data class JsonListContainerDto (

    @SerializedName("Data")
    val data: List<JsonContainerDto>? = null
)