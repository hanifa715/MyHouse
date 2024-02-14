package com.example.myhouse.utils

import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

fun Fragment.showToast(message:String){
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).into(this)
}