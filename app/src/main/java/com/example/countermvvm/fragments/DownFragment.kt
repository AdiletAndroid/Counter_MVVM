package com.example.countermvvm.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.countermvvm.databinding.FragmentDownBinding
import com.example.countermvvm.viewModel.ViewModel

class DownFragment : Fragment() {

    lateinit var binding: FragmentDownBinding

    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity())[ViewModel::class.java]
        binding = FragmentDownBinding.inflate(inflater)
        binding.buttonIncrement.setOnClickListener {
            viewModel.increment()
        }

        binding.buttonDecrement.setOnClickListener {
            viewModel.decrement()
        }

        return binding.root
    }
}