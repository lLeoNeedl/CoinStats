package com.example.coinstats.data.mapper

import com.example.coinstats.data.database.model.CoinDbModel
import com.example.coinstats.data.network.model.CoinDto
import com.example.coinstats.data.network.model.CoinInfoJsonContainerDto
import com.example.coinstats.data.network.model.TopCoinsListDto
import com.example.coinstats.domain.entities.Coin
import com.google.gson.Gson
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

class CoinStatsMapper {

    fun mapTopCoinDtoToDbModel(coinDto: CoinDto) = CoinDbModel(
        fromSymbol = coinDto.fromSymbol ?: EMPTY_SYMBOL,
        toSymbol = coinDto.toSymbol ?: EMPTY_SYMBOL,
        price = coinDto.price ?: EMPTY_VALUE,
        lastUpdate = coinDto.lastUpdate ?: EMPTY_VALUE.toLong(),
        highDay = coinDto.highDay ?: EMPTY_VALUE,
        lowDay = coinDto.lowDay ?: EMPTY_VALUE,
        marketCap = coinDto.marketCap ?: EMPTY_VALUE.toLong(),
        imageUrl = getFullImageUrl(coinDto.imageUrl)
    )

    fun mapJsonContainerToListDto(jsonContainer: CoinInfoJsonContainerDto): List<CoinDto> {
        val result = mutableListOf<CoinDto>()
        val jsonObject = jsonContainer.json ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinDto::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    fun mapNamesListToString(namesList: TopCoinsListDto) =
        namesList.data?.map { it.coinName?.name }?.joinToString(",") ?: ""

    fun mapTopCoinDbModelToEntity(coinDbModel: CoinDbModel) = Coin(
        fromSymbol = coinDbModel.fromSymbol,
        toSymbol = coinDbModel.toSymbol,
        price = coinDbModel.price,
        lastUpdate = getFormattedTime(coinDbModel.lastUpdate),
        highDay = coinDbModel.highDay,
        lowDay = coinDbModel.lowDay,
        marketCap = coinDbModel.marketCap,
        imageUrl = coinDbModel.imageUrl
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