package com.example.myhouse.data.utils

import com.example.myhouse.domain.models.camera.CameraModel
import com.example.myhouse.domain.models.door.DoorModel


fun CameraModel.mapToCameraModel() =
    CameraModel(
        id = id,
        data = data,
        success = success
    )

fun DoorModel.mapToDoorModel() =
    DoorModel(
        id = id,
        data = data,
        success = success
    )