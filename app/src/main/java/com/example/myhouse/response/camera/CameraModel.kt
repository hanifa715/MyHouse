package com.example.myhouse.response.camera

data class CameraModel(
    val `data`: List<Data>,
    val success: Boolean
) {
    data class Data(
        val cameras: List<Camera>,
        val room: String
    ) {
        data class Camera(
            val favorites: Boolean,
            val id: Int,
            val name: String,
            val rec: Boolean,
            val room: String,
            val snapshot: String
        )
    }
}