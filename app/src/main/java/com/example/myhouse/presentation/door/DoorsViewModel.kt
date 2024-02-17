package com.example.myhouse.presentation.door

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhouse.data.utils.Resource
import com.example.myhouse.domain.models.door.DoorModel
import com.example.myhouse.domain.usecases.GetDoorsUseCase
import com.example.myhouse.domain.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DoorsViewModel @Inject constructor(
    private val getDoorsUseCase: GetDoorsUseCase
) : ViewModel() {
    private var _doorsFlow = MutableStateFlow<UiState<DoorModel>>(UiState.Loading())
    var doorsFlow: StateFlow<UiState<DoorModel>> = _doorsFlow

    suspend fun getDoors() {
        viewModelScope.launch {
            getDoorsUseCase.getDoors().collect {
                when (it) {
                    is Resource.Error -> _doorsFlow.value = UiState.Error(it.message)
                    is Resource.Loading -> _doorsFlow.value = UiState.Loading()
                    is Resource.Success -> {
                        if (it.data != null) {
                            _doorsFlow.value = UiState.Success(it.data)
                        } else {
                            _doorsFlow.value = UiState.Empty("DATA IS EMPTY")
                        }
                    }
                }
            }
        }
    }
}