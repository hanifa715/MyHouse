package com.example.myhouse.presentation.door

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.myhouse.R
import com.example.myhouse.base.BaseFragment
import com.example.myhouse.databinding.FragmentDoorsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoorsFragment : BaseFragment() {
    private lateinit var binding:FragmentDoorsBinding
    private val viewModel: DoorsViewModel by viewModels()
    private val adapter = DoorsAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDoorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.doorsRecyclerView.adapter = adapter
        viewModel.getDoors().stateHandler(
            success = {
                adapter.setDataAdapter(it.data)
            }
        )
    }
}