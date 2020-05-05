package com.app.mvvmretrofit.model.response

import androidx.room.ColumnInfo
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class Article(
    @ColumnInfo(name = "author")
    val author: String,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "publishedAt")
    val publishedAt: String,
    @TypeConverters(SourceTypeConverter::class)
    @ColumnInfo(name = "source")
    val source: Source,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "urlToImage")
    val urlToImage: String
) {
    class SourceTypeConverter {
        @TypeConverter
        fun fromSourceList(source: Source?): String? {
            if (source == null) {
                return null
            }
            val gson = Gson()
            val type = object : TypeToken<Source>() {

            }.type
            return gson.toJson(source, type)
        }

        @TypeConverter
        fun toSourceList(source: String?): Source? {
            if (source == null) {
                return null
            }
            val gson = Gson()
            val type = object : TypeToken<Source>() {

            }.type
            return gson.fromJson(source, type)
        }
    }
}