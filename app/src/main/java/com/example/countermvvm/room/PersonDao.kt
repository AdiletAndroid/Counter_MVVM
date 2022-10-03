package com.example.countermvvm.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.countermvvm.model.Person

@Dao
interface PersonDao {

    @Query("SELECT * FROM Person ORDER BY firstName ASC")
    fun getAll(): LiveData<List<PersonEntity>>

    @Insert
    fun insert(person: PersonEntity)

    @Delete
    fun delete(person: PersonEntity)


}