package com.example.testtask

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    fun loadBooks(@Url route: String): Call<ArrayList<Book>>?

    @GET
    fun loadBookImages(@Url route: String): Call<ArrayList<Image>>?

}