package com.kyriniy.dinnner.data.repository

import com.kyriniy.dinnner.data.api.ApiService
import com.kyriniy.dinnner.data.api.dto.Container
import com.kyriniy.dinnner.domain.GameRepository

class GameRepositoryImpl (private val apiService: ApiService): GameRepository {

    /**
     * Отправляю данные на сервер
     */
    override suspend fun getData(): Container {
        return apiService.getDataServer()
    }
}