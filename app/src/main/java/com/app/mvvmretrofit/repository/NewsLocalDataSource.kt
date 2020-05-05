package com.sankha.daggerdemo2.login.viewmodel

import com.app.mvvmretrofit.model.response.Article
import com.app.mvvmretrofit.model.response.NewsResponse

interface NewsLocalDataSource {

    fun saveRequest(userResponseModel: List<Article>)
}