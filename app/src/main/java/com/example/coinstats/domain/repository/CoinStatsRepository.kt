package com.example.coinstats.domain.repository

import androidx.lifecycle.LiveData
import com.example.coinstats.domain.entities.TopCoin

interface CoinStatsRepository {

    fun getTopCoinList(): LiveData<List<TopCoin>>

    fun getTopCoin(fromSymbol: String): LiveData<TopCoin>

    suspend fun loadData()
}