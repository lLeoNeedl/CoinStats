package com.example.coinstats.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coinstats.data.database.model.TopCoinDbModel

@Dao
interface TopCoinsDao {

    @Query("SELECT * FROM top_coins_by_market_cap ORDER BY marketCap LIMIT 100")
    fun getTopCoinInfoList(): LiveData<List<TopCoinDbModel>>

    @Query("SELECT * FROM top_coins_by_market_cap WHERE fromSymbol == :fromSymbol LIMIT 1")
    fun getTopCoinInfo(fromSymbol: String): LiveData<TopCoinDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopCoins(coinList: List<TopCoinDbModel>)
}