package com.example.countermvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countermvvm.core.UIState
import com.example.countermvvm.model.Person
import com.example.countermvvm.repository.Repository

class ViewModel constructor(private val repository: Repository) : ViewModel() {

    fun saveToDatabase(person: Person) {
        repository.saveToDatabase(person)
    }
}