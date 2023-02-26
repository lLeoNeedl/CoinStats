package com.example.coinstats.domain.usecases

import com.example.coinstats.domain.repository.CoinStatsRepository

class GetTopCoinListUseCase(private val coinStatsRepository: CoinStatsRepository) {

    operator fun invoke() = coinStatsRepository.getTopCoinList()
}