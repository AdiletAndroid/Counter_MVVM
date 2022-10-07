package com.example.countermvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countermvvm.core.UIState
import com.example.countermvvm.model.Person
import com.example.countermvvm.repository.Repository

class PersonViewModel constructor(private val repository: Repository) : ViewModel() {

    private val _personsLiveData = MutableLiveData<UIState<List<Person>>>()
    val personsLiveData = _personsLiveData as LiveData<UIState<List<Person>>>


    fun getAllPersons() {
        _personsLiveData.value = UIState.Success(repository.getAllPersons())
    }
}
