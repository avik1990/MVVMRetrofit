package com.app.mvvmretrofit.repository

import com.app.mvvmretrofit.others.RetrofitClient

object NewsProvider {

    fun getNewsRepository(): NewsRepository {
        return NewsRepository(
            RetrofitClient.getClient()!!.create(NewsDataSource::class.java))
    }
}