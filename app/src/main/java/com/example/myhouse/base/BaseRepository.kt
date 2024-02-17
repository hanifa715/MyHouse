package com.example.myhouse.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.myhouse.data.repository.Resource
import kotlinx.coroutines.Dispatchers

abstract class BaseRepository {
    fun <T> performRequest(apiCall: suspend () -> T):LiveData<Resource<T>> =
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                val response = apiCall.invoke()
                if (response != null){
                    emit(Resource.Success(response))
                }
            } catch (ex: Exception) {
                emit(Resource.Error(ex.localizedMessage ?: "Unknown Error"))
                Log.e("performRequest", "${ex.message}")
            }
        }
}