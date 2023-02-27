package com.example.coinstats.data.network

import kotlinx.coroutines.flow.flow

class ApiHelper(private val apiService: ApiService) {

    fun getFullPriceList(fromSymbols: String) = flow {
        emit(apiService.getFullPriceList(fSyms = fromSymbols))
    }
}