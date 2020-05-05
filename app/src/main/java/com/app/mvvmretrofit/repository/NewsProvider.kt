package com.app.mvvmretrofit.repository

import com.app.mvvmretrofit.others.RetrofitClient
import com.sankha.daggerdemo2.login.viewmodel.NewsLocalDataSource

object NewsProvider {

    fun getNewsRepository(): NewsRepository {
        return NewsRepository(
            RetrofitClient.getClient()!!.create(NewsDataSource::class.java))
    }
}