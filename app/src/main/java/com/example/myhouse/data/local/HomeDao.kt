package com.example.myhouse.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myhouse.data.local.models.CameraData
import com.example.myhouse.data.local.models.DoorData

@Dao
interface HomeDao {

    @Insert
    fun insertCameraData(model: CameraData)

    @Insert
    fun insertDoorData(model: DoorData)

    @Query("SELECT COUNT(*) FROM camera_data")
    fun getCameraCount():Int
    @Query("SELECT COUNT(*) FROM door_data")
    fun getDoorCount():Int
}