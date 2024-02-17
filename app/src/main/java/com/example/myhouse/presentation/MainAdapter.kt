package com.example.myhouse.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myhouse.presentation.camera.CameraFragment
import com.example.myhouse.presentation.door.DoorsFragment

class MainAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 0)
            CameraFragment()
        else
            DoorsFragment()
    }
}