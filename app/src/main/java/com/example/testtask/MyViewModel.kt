package com.example.testtask

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    val booksLiveData = MutableLiveData<ArrayList<Book>>()
    val bookImagesLiveData = MutableLiveData<ArrayList<Image>>()
    val bookSimilarLiveData = MutableLiveData<ArrayList<Image>>()
    private lateinit var job: Job

    fun onCreateBookList() {
        job = viewModelScope.launch(Dispatchers.IO) {
            booksLiveData.postValue(Repository().getBest())
            bookImagesLiveData.postValue(Repository().getCarousel())
        }
    }

    fun onCreateBookInfo() {
        job = viewModelScope.launch(Dispatchers.IO) {
            bookSimilarLiveData.postValue(Repository().getSimilar())
        }
    }

}