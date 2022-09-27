package com.example.countermvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {

    private val _counterLiveData = MutableLiveData<Int>()
    val counterLiveData = _counterLiveData as LiveData<Int>
    private var counter = 0

    fun increment(){
        counter++
        _counterLiveData.value = counter
    }

    fun decrement(){
        counter--
        _counterLiveData.value = counter
    }

}