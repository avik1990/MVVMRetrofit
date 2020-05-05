package com.app.mvvmretrofit.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.mvvmretrofit.model.response.Article
import com.app.mvvmretrofit.model.response.NewsResponse

@Database(entities = [NewsResponse::class], version = 1, exportSchema = false)
@TypeConverters(Article.SourceTypeConverter::class)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDataDao(): NewsDao

    companion object {
        private var INSTANCE: NewsDatabase? = null

        fun getInstance(context: Context): NewsDatabase? {
            if (INSTANCE == null) {
                synchronized(NewsDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        NewsDatabase::class.java, "news.db"
                    )
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }


}