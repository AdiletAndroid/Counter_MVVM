package com.example.countermvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countermvvm.core.Resource
import com.example.countermvvm.core.UIState
import com.example.countermvvm.model.Person
import com.example.countermvvm.repository.Repository

class ViewModel : ViewModel() {

    private val repository = Repository()
    private val _personsLiveData = MutableLiveData<UIState<MutableList<Person>>>()
    val personsLiveData = _personsLiveData as LiveData<UIState<MutableList<Person>>>

    fun getAllPersons() {
        when (val data = repository.getAllPersons().value) {
            is Resource.Loading -> {
                _personsLiveData.value = UIState.Loading()
            }
            is Resource.Error -> {
                _personsLiveData.value = UIState.Error("Something is not OK.")
            }
            is Resource.Success -> {
                if (data.data != null) {
                    _personsLiveData.value = UIState.Success(data.data)
                }
            }
            else -> {}
        }
    }
}