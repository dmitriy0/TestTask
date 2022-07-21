package com.example.testtask

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type

class Repository {

    fun getBest(): ArrayList<Book>? {
        return try {
            val call: Call<ArrayList<Book>>? = getApiService().loadBooks("best")
            call!!.execute().body()!!
        } catch (e: Exception) {
            null
        }
    }

    fun getCarousel(): ArrayList<Image>? {
        return try {
            val call: Call<ArrayList<Image>>? = getApiService().loadBookImages("carousel")
            call!!.execute().body()!!
        } catch (e: Exception) {
            null
        }
    }

    fun getSimilar(): ArrayList<Image>? {
        return try {
            val call: Call<ArrayList<Image>>? = getApiService().loadBookImages("similar")
            call!!.execute().body()!!
        } catch (e: Exception) {
            null
        }
    }

    private fun getApiService(): ApiService {
        val httpClient = OkHttpClient.Builder()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/stellardiver/ebookdata/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
        return retrofit.create(ApiService::class.java)
    }

}