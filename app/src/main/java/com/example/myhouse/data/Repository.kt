package com.example.myhouse.data

import androidx.lifecycle.LiveData
import com.bumptech.glide.load.engine.Resource
import com.example.myhouse.base.BaseRepository
import com.example.myhouse.response.camera.CameraModel
import com.example.myhouse.response.door.DoorModel
import javax.inject.Inject


class Repository @Inject constructor(private val apiService: ApiService): BaseRepository(apiService) {
    fun getCameras(): LiveData<com.example.myhouse.data.Resource<List<CameraModel.Data.Camera>>> = performRequest {
        apiService.getCameras().body()!!
    }

    fun getDoors(): LiveData<com.example.myhouse.data.Resource<List<DoorModel.Data>>> = performRequest{
        apiService.getDoors().body()!!
    }
}