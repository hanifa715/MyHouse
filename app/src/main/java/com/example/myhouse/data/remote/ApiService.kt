package com.example.myhouse.data.remote


import com.example.myhouse.domain.models.camera.CameraModel
import com.example.myhouse.domain.models.door.DoorModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("cameras/")
    suspend fun getCameras(): Response<CameraModel>

    @GET("doors/")
    suspend fun getDoors(): Response<DoorModel>
}