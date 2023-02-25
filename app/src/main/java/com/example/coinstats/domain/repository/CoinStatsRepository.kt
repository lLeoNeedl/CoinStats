package com.example.coinstats.domain.repository

import androidx.lifecycle.LiveData
import com.example.coinstats.domain.entities.CoinInfo

interface CoinStatsRepository {

    fun getCoinInfoList(): LiveData<List<CoinInfo>>

    fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo>

    suspend fun loadData()
}