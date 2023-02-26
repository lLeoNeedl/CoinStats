package com.example.coinstats.data.mapper

import com.example.coinstats.data.database.model.TopCoinDbModel
import com.example.coinstats.data.network.model.TopCoinDto
import com.example.coinstats.data.network.model.JsonListContainerDto
import com.example.coinstats.domain.entities.TopCoin
import com.google.gson.Gson
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

class CoinStatsMapper {

    fun mapTopCoinDtoToDbModel(topCoinDto: TopCoinDto) = TopCoinDbModel(
        fromSymbol = topCoinDto.fromSymbol ?: EMPTY_SYMBOL,
        toSymbol = topCoinDto.toSymbol ?: EMPTY_SYMBOL,
        price = topCoinDto.price ?: EMPTY_VALUE,
        lastUpdate = topCoinDto.lastUpdate ?: EMPTY_VALUE.toLong(),
        highDay = topCoinDto.highDay ?: EMPTY_VALUE,
        lowDay = topCoinDto.lowDay ?: EMPTY_VALUE,
        marketCap = topCoinDto.marketCap ?: EMPTY_VALUE.toLong(),
        imageUrl = getFullImageUrl(topCoinDto.imageUrl)
    )

    fun mapJsonContainerToListDto(jsonListContainer: JsonListContainerDto): List<TopCoinDto> {
        val result = mutableListOf<TopCoinDto>()
        val jsonList = jsonListContainer.data ?: return result
        for (jsonContainer in jsonList) {
            val jsonObject = jsonContainer.json ?: return result
            val currencyKeySet = jsonObject.keySet()
            for (currencyKey in currencyKeySet) {
                val topCoin = Gson().fromJson(
                    jsonObject.getAsJsonObject(currencyKey),
                    TopCoinDto::class.java
                )
                result.add(topCoin)
            }
        }
        return result
    }

    fun mapTopCoinDbModelToEntity(topCoinDbModel: TopCoinDbModel) = TopCoin(
        fromSymbol = topCoinDbModel.fromSymbol,
        toSymbol = topCoinDbModel.toSymbol,
        price = topCoinDbModel.price,
        lastUpdate = getFormattedTime(topCoinDbModel.lastUpdate),
        highDay = topCoinDbModel.highDay,
        lowDay = topCoinDbModel.lowDay,
        marketCap = topCoinDbModel.marketCap,
        imageUrl = topCoinDbModel.imageUrl
    )

    private fun getFormattedTime(timestamp: Long): String {
        val stamp = Timestamp(timestamp * 1000)
        val date = Date(stamp.time)
        val pattern = "HH:mm:ss"
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(date)
    }

    private fun getFullImageUrl(imageUrl: String?) =
        BASE_IMAGE_URL + imageUrl

    companion object {
        private const val EMPTY_SYMBOL = ""
        private const val EMPTY_VALUE = 0.0
        private const val BASE_IMAGE_URL = "https://cryptocompare.com"
    }
}