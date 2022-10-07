package com.example.countermvvm.model

import java.util.*

data class Person(
    val passportId: String = UUID.randomUUID().toString(),
    val age: Int,
    val name: String
)