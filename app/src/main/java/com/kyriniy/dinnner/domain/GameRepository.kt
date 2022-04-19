package com.kyriniy.dinnner.domain

import com.kyriniy.dinnner.data.api.dto.Container

interface GameRepository {
    suspend fun getData(): Container
}