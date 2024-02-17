package com.example.myhouse.domain.usecases

import com.example.myhouse.domain.repositories.DoorsRepository
import javax.inject.Inject


class GetDoorsUseCase @Inject constructor(
    private val doorsRepository: DoorsRepository
) {
    suspend fun getDoors() = doorsRepository.getDoors()
}