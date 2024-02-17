package com.example.myhouse.domain.repositories

import androidx.lifecycle.LiveData
import com.example.myhouse.data.repository.Resource
import com.example.myhouse.data.response.camera.CameraModel

interface CamerasRepository {
    fun getCameras(): LiveData<Resource<CameraModel>>
}