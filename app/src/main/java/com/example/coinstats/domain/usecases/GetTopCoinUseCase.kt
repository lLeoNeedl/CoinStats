package com.example.coinstats.domain.usecases

import com.example.coinstats.domain.repository.CoinStatsRepository

class GetTopCoinUseCase(private val coinStatsRepository: CoinStatsRepository) {

    operator fun invoke(fromSymbol: String) =
        coinStatsRepository.getTopCoin(fromSymbol)
}