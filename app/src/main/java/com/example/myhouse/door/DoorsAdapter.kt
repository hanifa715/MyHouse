package com.example.myhouse.door


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myhouse.databinding.ItemDoorsBinding


class DoorsAdapter : Adapter<DoorsAdapter.DoorsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorsViewHolder {
        return DoorsViewHolder(
            ItemDoorsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 100
    }

    override fun onBindViewHolder(holder: DoorsViewHolder, position: Int) {
        holder.bind()
    }

    inner class DoorsViewHolder(private val binding: ItemDoorsBinding) : ViewHolder(binding.root) {
        fun bind() = with(binding) {
            itemView.setOnClickListener {
                if (imgDoor.visibility == View.GONE) {
                    imgDoor.visibility = View.VISIBLE
                } else {
                    imgDoor.visibility = View.GONE
                }
            }
        }

    }
}