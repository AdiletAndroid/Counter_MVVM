package com.example.countermvvm.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countermvvm.adapter.ListAdapter
import com.example.countermvvm.core.UIState
import com.example.countermvvm.databinding.FragmentDownBinding
import com.example.countermvvm.viewModel.PersonViewModel

class DownFragment : Fragment() {

    lateinit var binding: FragmentDownBinding

    lateinit var adapter: ListAdapter

    private lateinit var viewModel: PersonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity())[PersonViewModel::class.java]
        binding = FragmentDownBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ListAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.getAllPersons()

        viewModel.personsLiveData.observe(requireActivity()) { state ->
            when (state) {
                is UIState.Loading -> {
                }
                is UIState.Error -> {
                    Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                }
                is UIState.Success -> {
                    adapter.setItems(state.data)
                }
            }
        }
    }
}