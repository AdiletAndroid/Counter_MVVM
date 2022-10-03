package com.example.countermvvm.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Person")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val firstName: String,
    val age: Int
)