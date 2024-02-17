package com.example.myhouse.presentation.door

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myhouse.data.repository.Resource
import com.example.myhouse.data.response.door.DoorModel
import com.example.myhouse.domain.usecases.GetDoorsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DoorsViewModel @Inject constructor(private val getDoorsUseCase: GetDoorsUseCase):ViewModel() {
    fun getDoors():LiveData<Resource<DoorModel>> = getDoorsUseCase.getDoors()
}