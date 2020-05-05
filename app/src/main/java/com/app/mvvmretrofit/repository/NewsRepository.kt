package com.app.mvvmretrofit.repository

import androidx.lifecycle.MutableLiveData
import com.app.mvvmretrofit.model.response.NewsResponse
import com.sankha.daggerdemo2.login.viewmodel.NewsLocalDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository(
    private val dateSource: NewsDataSource,
    private val localdateSource: NewsLocalDataSource
) {

    lateinit var newsLiveData: MutableLiveData<NewsResponse?>
    lateinit var newsResponseModel: NewsResponse

    fun getNewsServices(date: String, sortby: String, apiKey: String) {
        dateSource.callNewsService(date, sortby, apiKey)
            .enqueue(object : Callback<NewsResponse> {

                override fun onFailure(call: Call<NewsResponse>?, t: Throwable?) {
                    newsLiveData.postValue(null)
                }

                override fun onResponse(
                    call: Call<NewsResponse>?,
                    response: Response<NewsResponse>?
                ) {
                    if (response?.isSuccessful ?: false) {
                        response?.body()?.let {
                            newsResponseModel = it
                            newsLiveData.postValue(it)
                        }
                    } else newsLiveData.postValue(null)
                }
            })
    }
}