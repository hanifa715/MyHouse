package com.example.myhouse.door

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myhouse.data.Repository
import com.example.myhouse.data.Resource
import com.example.myhouse.response.camera.CameraModel
import com.example.myhouse.response.door.DoorModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DoorsViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    fun getDoors():LiveData<Resource<List<DoorModel.Data>>> = repository.getDoors()
}