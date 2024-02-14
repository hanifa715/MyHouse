package com.example.myhouse.door

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myhouse.databinding.ItemDoorsBinding
import com.example.myhouse.response.door.DoorModel
import com.example.myhouse.utils.loadImage


class DoorsAdapter : ListAdapter<DoorModel.Data, DoorsViewHolder>(
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
}

class DoorsViewHolder(private val binding: ItemDoorsBinding) : ViewHolder(binding.root) {
    fun bind(position: DoorModel.Data) = with(binding) {
        itemView.setOnClickListener {
            if (imgDoor.visibility == View.GONE) {
                imgDoor.visibility = View.VISIBLE
            } else {
                imgDoor.visibility = View.GONE

            }
        }
        tvNameDoor.text = position.name
        imgDoor.loadImage(position.snapshot)
    }
}

class DoorDiffCallback : DiffUtil.ItemCallback<DoorModel.Data>() {
    override fun areContentsTheSame(oldItem: DoorModel.Data, newItem: DoorModel.Data) =
        oldItem.id == newItem.id

    override fun areItemsTheSame(oldItem: DoorModel.Data, newItem: DoorModel.Data) =
        oldItem == newItem
}