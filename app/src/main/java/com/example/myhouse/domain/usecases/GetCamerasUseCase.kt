package com.example.myhouse.domain.usecases

import com.example.myhouse.domain.repositories.CamerasRepository
import javax.inject.Inject

class GetCamerasUseCase @Inject constructor(
    private val camerasRepository: CamerasRepository
) {
    suspend fun getCameras() = camerasRepository.getCameras()
}