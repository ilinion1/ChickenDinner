package com.kyriniy.dinnner.presentation

import androidx.lifecycle.ViewModel
import com.kyriniy.dinnner.data.api.ApiFactory
import com.kyriniy.dinnner.data.api.dto.Container
import com.kyriniy.dinnner.data.repository.GameRepositoryImpl
import com.kyriniy.dinnner.domain.SendDataUseCase
import javax.inject.Inject

class GameViewModel: ViewModel() {
    private val api = ApiFactory.create()
    private val repository = GameRepositoryImpl(api)
    private val sendDataUseCase = SendDataUseCase(repository)

    var level = "normal"
    var coin = 100
    var maxResult= 100
    var count = 1
    var recordList = arrayListOf<String>()
    var countList = arrayListOf<String>()

    suspend fun getData(): Container {
        return sendDataUseCase()
    }
}