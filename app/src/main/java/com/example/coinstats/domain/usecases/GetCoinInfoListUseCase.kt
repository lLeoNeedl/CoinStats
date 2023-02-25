package com.example.coinstats.domain.usecases

import androidx.lifecycle.LiveData
import com.example.coinstats.domain.repository.CoinStatsRepository

class GetCoinInfoListUseCase(private val coinStatsRepository: CoinStatsRepository) {

    operator fun invoke() = coinStatsRepository.getCoinInfoList()
}