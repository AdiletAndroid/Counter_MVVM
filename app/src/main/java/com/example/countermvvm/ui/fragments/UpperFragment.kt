package com.example.countermvvm.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.countermvvm.core.UIState
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

        viewModel.getAllPersons()

        viewModel.personsLiveData.observe(requireActivity()) { state ->
            when (state) {
                is UIState.Loading -> {
                    binding.progressBar.isVisible = true
                }
                is UIState.Error -> {
                    binding.progressBar.isVisible = false
                }
                is UIState.Success -> {
                    binding.progressBar.isVisible = false
                    binding.textViewCounter.text = state.data.toString()
                }
            }
        }

        return binding.root
    }
}