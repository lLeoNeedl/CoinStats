package com.example.coinstats.data.repository_impl

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.coinstats.data.database.AppDatabase
import com.example.coinstats.data.mapper.CoinStatsMapper
import com.example.coinstats.data.network.ApiFactory
import com.example.coinstats.data.network.model.JsonListContainerDto
import com.example.coinstats.domain.entities.TopCoin
import com.example.coinstats.domain.repository.CoinStatsRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.retry

class CoinStatsRepositoryImpl(application: Application) : CoinStatsRepository {

    private val topCoinsDao = AppDatabase.getInstance(application).getTopCoinsDao()
    private val apiService = ApiFactory.apiService
    private val mapper = CoinStatsMapper()

    override fun getTopCoinList(): LiveData<List<TopCoin>> =
        Transformations.map(topCoinsDao.getTopCoinInfoList()) {
            it.map { mapper.mapTopCoinDbModelToEntity(it) }
        }

    override fun getTopCoin(fromSymbol: String): LiveData<TopCoin> =
        Transformations.map(topCoinsDao.getTopCoinInfo(fromSymbol)) {
            mapper.mapTopCoinDbModelToEntity(it)
        }

    override suspend fun loadData() {
        while (true) {
            val jsonListContainer = apiService.getTopCoins()
            val topCoinDtoList = mapper.mapJsonContainerToListDto(jsonListContainer)
            val topCoinDbModelList =
                topCoinDtoList.map { mapper.mapTopCoinDtoToDbModel(it) }
            topCoinsDao.insertTopCoins(topCoinDbModelList)
            delay(10000)
        }
    }

    private fun loadDataFromInternet(): Flow<JsonListContainerDto> {
        return flow {
            emit(apiService.getTopCoins())
        }
    }
}