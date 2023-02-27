package com.example.coinstats.domain.repository

import androidx.lifecycle.LiveData
import com.example.coinstats.domain.entities.Coin

interface CoinStatsRepository {

    fun getTopCoinList(): LiveData<List<Coin>>

    fun getTopCoin(fromSymbol: String): LiveData<Coin>

    suspend fun loadData()
}