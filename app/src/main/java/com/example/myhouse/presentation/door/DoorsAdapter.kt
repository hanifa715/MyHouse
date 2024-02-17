package com.example.myhouse.presentation.door

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myhouse.databinding.ItemDoorsBinding
import com.example.myhouse.domain.models.door.DoorModel
import com.example.myhouse.utils.loadImage

class DoorsAdapter : ListAdapter<DoorModel.Data, DoorsAdapter.DoorsViewHolder>(
    DoorDiffCallback()
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DoorsViewHolder {
        return DoorsViewHolder(
            ItemDoorsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DoorsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class DoorsViewHolder(private val binding: ItemDoorsBinding) : ViewHolder(binding.root) {
        fun bind(item: DoorModel.Data) = with(binding) {
            tvNameDoor.text = item.name
            imgDoor.loadImage(item.snapshot)
        }
    }

}

class DoorDiffCallback : DiffUtil.ItemCallback<DoorModel.Data>() {
    override fun areItemsTheSame(oldItem: DoorModel.Data, newItem: DoorModel.Data) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: DoorModel.Data, newItem: DoorModel.Data) =
        oldItem == newItem

}