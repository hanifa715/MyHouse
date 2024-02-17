package com.example.myhouse.presentation.camera

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhouse.data.utils.Resource
import com.example.myhouse.domain.models.camera.CameraModel
import com.example.myhouse.domain.usecases.GetCamerasUseCase
import com.example.myhouse.domain.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(
    private val getCamerasUseCase: GetCamerasUseCase
):ViewModel() {
    private var _camerasFlow = MutableStateFlow<UiState<CameraModel>>(UiState.Loading())
    var camerasFlow: StateFlow<UiState<CameraModel>> = _camerasFlow

    suspend fun getCameras() {
        viewModelScope.launch {
            getCamerasUseCase.getCameras().collect {
                when (it) {
                    is Resource.Error -> _camerasFlow.value = UiState.Error(it.message)
                    is Resource.Loading -> _camerasFlow.value = UiState.Loading()
                    is Resource.Success -> {
                        if (it.data != null) {
                            _camerasFlow.value = UiState.Success(it.data)
                        } else {
                            _camerasFlow.value = UiState.Empty("DATA IS EMPTY")
                        }
                    }
                }
            }
        }
    }
}