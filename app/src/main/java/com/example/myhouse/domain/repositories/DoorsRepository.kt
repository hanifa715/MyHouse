package com.example.myhouse.domain.repositories

import androidx.lifecycle.LiveData
import com.example.myhouse.data.repository.Resource
import com.example.myhouse.data.response.door.DoorModel

interface DoorsRepository {
    fun getDoors(): LiveData<Resource<DoorModel>>
}