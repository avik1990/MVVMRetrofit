package com.app.mvvmretrofit.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.mvvmretrofit.model.response.NewsResponse

@Dao
interface NewsDao {

    @Insert
    fun insertNews(newsResponse: List<NewsResponse>)

    @Query("Select * from tbl_news")
    fun getAllNews(): List<NewsResponse>
}