package com.example.coinstats.data.network

import com.example.coinstats.data.network.model.TopCoinsList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top/mktcapfull")
    suspend fun getTopCoins(
        @Query(QUERY_PARAM_API_KEY) apiKey: String =
            "8de3a974a8c29dc177e736af0fac6b9dad01075045e0655580980b8899b97077",
        @Query(QUERY_PARAM_LIMIT) limit: Int = 100,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym: String = CURRENCY
    ): TopCoinsList

    companion object {
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val CURRENCY = "USD"
    }
}