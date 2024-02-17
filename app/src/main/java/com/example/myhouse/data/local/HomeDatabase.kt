package com.example.myhouse.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myhouse.data.local.models.CameraData
import com.example.myhouse.data.local.models.DoorData

@Database(entities = [CameraData::class, DoorData::class], version = 2)
abstract class HomeDatabase : RoomDatabase() {
    abstract fun homeDao(): HomeDao
}