package com.example.coinstats.data.repository_impl

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.coinstats.data.database.AppDatabase
import com.example.coinstats.data.mapper.CoinStatsMapper
import com.example.coinstats.data.network.ApiFactory
import com.example.coinstats.data.network.ApiHelper
import com.example.coinstats.data.network.model.JsonListContainerDto
import com.example.coinstats.domain.entities.TopCoin
import com.example.coinstats.domain.repository.CoinStatsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class CoinStatsRepositoryImpl(application: Application) : CoinStatsRepository {

    private val topCoinsDao = AppDatabase.getInstance(application).getTopCoinsDao()
    private val apiHelper = ApiHelper(ApiFactory.apiService)
    private val mapper = CoinStatsMapper()
    private val apiService = ApiFactory.apiService

    override fun getTopCoinList(): LiveData<List<TopCoin>> =
        Transformations.map(topCoinsDao.getTopCoinInfoList()) {
            it.map { mapper.mapTopCoinDbModelToEntity(it) }
        }

    override fun getTopCoin(fromSymbol: String): LiveData<TopCoin> =
        Transformations.map(topCoinsDao.getTopCoinInfo(fromSymbol)) {
            mapper.mapTopCoinDbModelToEntity(it)
        }

    override suspend fun loadData() {
        apiHelper.getTopCoins()
            .retry()
            .map {
                mapper.mapJsonContainerToListDto(it)
            }
            .map {
                it.map { mapper.mapTopCoinDtoToDbModel(it) }
            }
            .collect {
//                topCoinsDao.insertTopCoins(it)
                Log.d("MyTopCoinsFragment", it.toString())
            }
//        while (true) {
//            val jsonListContainer = ApiFactory.apiService.getTopCoins(limit = 50)
//            val x = ApiFactory.apiService.getTopCoins(limit = 50)
//            Log.d("CoinStatsRepositoryImpl", jsonListContainer.data.toString())
//            Log.d("CoinStatsRepositoryImpl", x.data.toString())
////            val topCoinDtoList = mapper.mapJsonContainerToListDto(jsonListContainer)
//            delay(10000)
//        }
//        val topCoinDbModelList =
//            topCoinDtoList.map { mapper.mapTopCoinDtoToDbModel(it) }
//        topCoinsDao.insertTopCoins(topCoinDbModelList)
    }
}