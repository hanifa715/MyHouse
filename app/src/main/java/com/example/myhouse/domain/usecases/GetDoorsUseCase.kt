package com.example.myhouse.domain.usecases

import androidx.lifecycle.LiveData
import com.example.myhouse.data.repository.Resource
import com.example.myhouse.data.response.door.DoorModel
import com.example.myhouse.domain.repositories.DoorsRepository
import javax.inject.Inject


class GetDoorsUseCase @Inject constructor(private val doorsRepository: DoorsRepository) {
    fun getDoors(): LiveData<Resource<DoorModel>> = doorsRepository.getDoors()
}