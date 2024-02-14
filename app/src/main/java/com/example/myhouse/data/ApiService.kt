package com.example.myhouse.data

import com.example.myhouse.response.camera.CameraModel
import com.example.myhouse.response.door.DoorModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("cameras")
    suspend fun getCameras(): Response<List<CameraModel.Data.Camera>>

    @GET("doors")
    suspend fun getDoors():Response<List<DoorModel.Data>>
}