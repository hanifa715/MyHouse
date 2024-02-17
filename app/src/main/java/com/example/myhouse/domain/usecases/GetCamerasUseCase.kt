package com.example.myhouse.domain.usecases

import androidx.lifecycle.LiveData
import com.example.myhouse.data.repository.Resource
import com.example.myhouse.data.response.camera.CameraModel
import com.example.myhouse.domain.repositories.CamerasRepository
import javax.inject.Inject

class GetCamerasUseCase @Inject constructor(private val camerasRepository: CamerasRepository) {
    fun getCameras(): LiveData<Resource<CameraModel>> = camerasRepository.getCameras()
}