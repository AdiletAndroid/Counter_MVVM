package com.example.countermvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.countermvvm.core.Resource
import com.example.countermvvm.model.Person
import com.example.countermvvm.room.PersonDao
import com.example.countermvvm.room.PersonEntity

class Repository(private val personDao: PersonDao) {

    fun getAllPersons(): List<Person> {
        Resource.Loading(null)
        return personDao.getAll().map {
            Person(
                passportId = it.passportId,
                age = it.age,
                name = it.firstName
            )
        }
    }

    fun saveToDatabase(person: Person) {
        val entity =
            PersonEntity(passportId = person.passportId, firstName = person.name, age = person.age)
        personDao.insert(entity)
    }

}