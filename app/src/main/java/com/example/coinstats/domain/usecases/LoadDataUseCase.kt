package com.example.coinstats.domain.usecases

import com.example.coinstats.domain.repository.CoinStatsRepository

class LoadDataUseCase(private val coinStatsRepository: CoinStatsRepository) {

    suspend operator fun invoke() {
        coinStatsRepository.loadData()
    }
}