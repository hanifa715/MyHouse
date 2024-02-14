package com.example.myhouse.camera

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.myhouse.base.BaseFragment
import com.example.myhouse.databinding.FragmentCameraBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CameraFragment : BaseFragment() {
    private lateinit var binding:FragmentCameraBinding
    private val viewModel:CameraViewModel by viewModels()
    private val adapter = CameraAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCameraBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCameras().stateHandler(
            success = {
                adapter.submitList(it)
                binding.recyclerView.adapter = adapter
            })
    }
}