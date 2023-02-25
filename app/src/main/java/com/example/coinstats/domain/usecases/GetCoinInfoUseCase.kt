package com.example.coinstats.domain.usecases

import com.example.coinstats.domain.repository.CoinStatsRepository

class GetCoinInfoUseCase(private val coinStatsRepository: CoinStatsRepository) {

    operator fun invoke(fromSymbol: String) =
        coinStatsRepository.getCoinInfo(fromSymbol)
}