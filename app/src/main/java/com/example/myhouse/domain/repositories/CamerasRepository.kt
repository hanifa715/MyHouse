package com.example.myhouse.domain.repositories

import com.example.myhouse.data.utils.Resource
import com.example.myhouse.domain.models.camera.CameraModel
import kotlinx.coroutines.flow.Flow
interface CamerasRepository {
    suspend fun getCameras(): Flow<Resource<CameraModel>>
}