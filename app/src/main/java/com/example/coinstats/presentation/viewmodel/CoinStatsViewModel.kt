package com.example.coinstats.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinstats.data.repository_impl.CoinStatsRepositoryImpl
import com.example.coinstats.domain.usecases.GetTopCoinListUseCase
import com.example.coinstats.domain.usecases.GetTopCoinUseCase
import com.example.coinstats.domain.usecases.LoadDataUseCase
import kotlinx.coroutines.launch

class CoinStatsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinStatsRepositoryImpl(application)
    private val getTopCoinUseCase = GetTopCoinUseCase(repository)
    private val getTopCoinListUseCase = GetTopCoinListUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val list = getTopCoinListUseCase()

    fun loadData() {
        viewModelScope.launch {
            loadDataUseCase()
        }
    }
}