package com.example.countermvvm.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.countermvvm.databinding.FragmentUpperBinding
import com.example.countermvvm.viewModel.ViewModel

class UpperFragment : Fragment() {

    private lateinit var binding: FragmentUpperBinding

    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity())[ViewModel::class.java]
        binding = FragmentUpperBinding.inflate(inflater)
        viewModel.counterLiveData.observe(requireActivity()) { id ->
            binding.textViewCounter.text = id.toString()
        }
        return binding.root
    }
}