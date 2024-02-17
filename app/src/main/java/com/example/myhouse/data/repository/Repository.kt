package com.example.myhouse.data.repository

import androidx.lifecycle.LiveData
import com.example.myhouse.base.BaseRepository
import com.example.myhouse.data.remote.ApiService
import com.example.myhouse.data.response.camera.CameraModel
import com.example.myhouse.data.response.door.DoorModel
import com.example.myhouse.domain.repositories.CamerasRepository
import com.example.myhouse.domain.repositories.DoorsRepository
import javax.inject.Inject


class Repository(private val apiService: ApiService) : CamerasRepository, DoorsRepository,
    BaseRepository() {
    override fun getCameras(): LiveData<Resource<CameraModel>> = performRequest {
        apiService.getCameras().body() as CameraModel
    }

    override fun getDoors(): LiveData<Resource<DoorModel>> = performRequest {
        apiService.getDoors().body() as DoorModel
    }
}