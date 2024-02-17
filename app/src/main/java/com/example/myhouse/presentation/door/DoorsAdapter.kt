package com.example.myhouse.presentation.door

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myhouse.databinding.ItemDoorsBinding
import com.example.myhouse.data.response.door.DoorModel
import com.example.myhouse.utils.loadImage


class DoorsAdapter(): RecyclerView.Adapter<DoorsAdapter.DoorsViewHolder>(){

    private var list = listOf<DoorModel.Data>()

    fun setDataAdapter(list: List<DoorModel.Data>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorsViewHolder {
        return DoorsViewHolder(ItemDoorsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: DoorsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class DoorsViewHolder(private val binding: ItemDoorsBinding) : ViewHolder(binding.root) {
        fun bind(position: DoorModel.Data) = with(binding) {
            itemView.setOnClickListener {
                if (imgDoor.visibility == View.GONE) {
                    imgDoor.visibility =
                        View.VISIBLE
                } else {
                    imgDoor.visibility = View.GONE
                }
            }
            tvNameDoor.text = position.name
            imgDoor.loadImage(position.snapshot)
        }
    }


}