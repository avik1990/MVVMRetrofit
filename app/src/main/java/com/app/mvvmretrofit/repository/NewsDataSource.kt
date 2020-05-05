package com.app.mvvmretrofit.repository

import com.app.mvvmretrofit.model.response.NewsResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import javax.security.auth.callback.Callback

interface NewsDataSource {

    @GET("v2/everything?q=bitcoin")
    fun callNewsService(
        @Query("date") date: String,
        @Query("sortBy") sortby: String,
        @Query("apiKey") apiKey: String
    ): Call<NewsResponse>
}