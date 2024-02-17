package com.example.myhouse.presentation.camera

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myhouse.data.repository.Resource
import com.example.myhouse.data.response.camera.CameraModel
import com.example.myhouse.domain.usecases.GetCamerasUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(private val getCamerasUseCase: GetCamerasUseCase):ViewModel() {
    fun getCameras():LiveData<Resource<CameraModel>> = getCamerasUseCase.getCameras()
}