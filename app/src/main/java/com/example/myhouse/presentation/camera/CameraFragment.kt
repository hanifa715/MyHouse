package com.example.myhouse.presentation.camera

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.myhouse.base.BaseFragment
import com.example.myhouse.data.local.HomeDao
import com.example.myhouse.data.local.models.CameraData
import com.example.myhouse.databinding.FragmentCameraBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CameraFragment : BaseFragment() {
    private lateinit var binding: FragmentCameraBinding
    private val viewModel: CameraViewModel by viewModels()
    private val adapter = CameraAdapter()
    @Inject
    lateinit var dao: HomeDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCameraBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        if (dao.getCameraCount() == 0) {
            viewModel.getCameras().stateHandler(
                success = {
                    adapter.submitList(it.data.cameras)
                    val data = CameraData(
                        count = adapter.currentList.size
                    )
                    dao.insertCameraData(data)
                }
            )
        } else {
            binding.cameraRefreshLayout.setOnRefreshListener {
                viewModel.getCameras().stateHandler(
                    success = {
                        adapter.submitList(it.data.cameras)
                    }
                )
                binding.cameraRefreshLayout.isRefreshing = false
            }
        }
    }
}