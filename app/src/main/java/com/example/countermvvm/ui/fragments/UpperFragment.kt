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
import com.example.countermvvm.model.Person
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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAdd.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val age = binding.editTextAge.text.toString()

            val person = Person(name = name, age = age.toInt())

            viewModel.saveToDatabase(person)
        }
    }
}