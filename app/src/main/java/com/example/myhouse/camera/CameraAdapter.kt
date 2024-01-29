package com.example.myhouse.camera

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myhouse.databinding.ItemCameraBinding

class CameraAdapter : Adapter<CameraAdapter.CameraViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CameraViewHolder {
        return CameraViewHolder(
            ItemCameraBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
    return 100
    }

    override fun onBindViewHolder(holder: CameraViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class CameraViewHolder(private val binding: ItemCameraBinding) :
        ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.tvRoomName.isVisible = position == 0
        }

    }
}