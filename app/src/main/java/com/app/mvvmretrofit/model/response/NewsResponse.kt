package com.app.mvvmretrofit.model.response

import androidx.room.Entity

@Entity(tableName = "tbl_news")
data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)