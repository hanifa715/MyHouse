package com.example.myhouse.domain.repositories

import com.example.myhouse.data.utils.Resource
import com.example.myhouse.domain.models.door.DoorModel
import kotlinx.coroutines.flow.Flow

interface DoorsRepository {
    suspend fun getDoors():Flow<Resource<DoorModel>>
}