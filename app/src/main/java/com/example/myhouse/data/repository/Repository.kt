package com.example.myhouse.data.repository

import com.example.myhouse.data.remote.ApiService
import com.example.myhouse.data.utils.Resource
import com.example.myhouse.data.utils.mapToCameraModel
import com.example.myhouse.data.utils.mapToDoorModel
import com.example.myhouse.domain.models.camera.CameraModel
import com.example.myhouse.domain.models.door.DoorModel
import com.example.myhouse.domain.repositories.CamerasRepository
import com.example.myhouse.domain.repositories.DoorsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class Repository(private val apiService: ApiService) : CamerasRepository, DoorsRepository {

    override suspend fun getCameras(): Flow<Resource<CameraModel>> =
        flow {
            emit(Resource.Loading())
            try {
                val result = apiService.getCameras().body()!!.mapToCameraModel()
                emit(Resource.Success(result))
            } catch (ex: Exception) {
                emit(Resource.Error(ex.message))
            }
        }

    override suspend fun getDoors(): Flow<Resource<DoorModel>> =
        flow {
            emit(Resource.Loading())
            try {
                val result = apiService.getDoors().body()!!.mapToDoorModel()
                emit(Resource.Success(result))
            } catch (ex: Exception) {
                emit(Resource.Error(ex.message))
            }
        }
}