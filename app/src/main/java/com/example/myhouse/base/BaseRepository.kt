package com.example.myhouse.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.myhouse.data.ApiService
import com.example.myhouse.data.Resource
import kotlinx.coroutines.Dispatchers


abstract class BaseRepository(private val api:ApiService) {
    fun <T> performRequest(apiCall: suspend () -> T):LiveData<Resource<T>> =
        liveData(Dispatchers.Main){
            emit(Resource.Loading())
            try {
                val response = apiCall.invoke()
                emit(Resource.Success(response))
            }catch (ex:Exception){
                emit(Resource.Error(ex.localizedMessage ?: "Unknown Error"))
                Log.e("performRequest", "${ex.message}")
            }
        }
}