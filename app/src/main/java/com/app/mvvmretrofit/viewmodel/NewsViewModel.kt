package com.app.mvvmretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.mvvmretrofit.model.response.NewsResponse
import com.app.mvvmretrofit.repository.NewsRepository

class NewsViewModel private constructor(private val newsRepository: NewsRepository) :
    ViewModel() {

    fun getFetchNewsAPI(date: String, sortby: String, apiKey: String) {
        newsRepository.getNewsServices(date, sortby, apiKey)
    }

    fun getNewsLiveData(): MutableLiveData<NewsResponse?> {
        return newsRepository.newsLiveData
    }

}