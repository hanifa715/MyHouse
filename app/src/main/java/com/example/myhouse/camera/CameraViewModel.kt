package com.example.myhouse.camera

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myhouse.data.Repository
import com.example.myhouse.data.Resource
import com.example.myhouse.response.camera.CameraModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun getCameras():LiveData<Resource<List<CameraModel.Data.Camera>>> = repository.getCameras()}