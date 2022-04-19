package com.kyriniy.dinnner.domain


class SendDataUseCase (private val repository: GameRepository) {
    suspend operator fun invoke() = repository.getData()
}