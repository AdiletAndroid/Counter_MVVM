package com.example.countermvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.countermvvm.core.Resource
import com.example.countermvvm.model.Person
import com.example.countermvvm.room.PersonDao
import com.example.countermvvm.room.PersonEntity

class Repository(private val personDao: PersonDao) {


    val getAll: LiveData<List<PersonEntity>> = personDao.getAll()

    fun addUser(person: PersonEntity) {
        personDao.insert(person)
    }

    fun deleteUser(person: PersonEntity){
        personDao.delete(person)
    }

    private val data = mutableListOf<Person>()

    fun addPerson(person: Person): LiveData<Resource<Person>> = liveData {
        Resource.Loading(null)
        Resource.Success(data.add(person))
    }

    fun getAllPersons(): LiveData<Resource<MutableList<Person>>> {
        Resource.Loading(null)
        return liveData {
            Resource.Success(data)
        }
    }

    fun deletePerson(person: Person): LiveData<Resource<Person>> = liveData {
        Resource.Loading(null)
        Resource.Success(person)

    }

}