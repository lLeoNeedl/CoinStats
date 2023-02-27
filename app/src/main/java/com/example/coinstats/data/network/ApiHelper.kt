package com.example.coinstats.data.network

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class ApiHelper(private val apiService: ApiService) {

    fun getTopCoins() = flow {
        emit(apiService.getTopCoins())
    }
}