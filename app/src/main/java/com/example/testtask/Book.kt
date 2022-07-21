package com.example.testtask

data class Book(
    val title: String,
    val author: String,
    val price: Double,
    val image: String,
    val rate: Rate
)

data class Rate(
    val score: Double,
    val amount: Int
)