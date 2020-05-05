package com.app.mvvmretrofit.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.app.mvvmretrofit.R
import com.app.mvvmretrofit.viewmodel.NewsViewModel

class MainActivity : AppCompatActivity() {

    lateinit var loginViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        //date: String, sortby: String, publishedAt: String, apiKey: String
        loginViewModel.getFetchNewsAPI("2019-08-24","publishedAt","4eb1483620174fba970d74a1cd7e300f")

        loginViewModel.getNewsLiveData().observe(this, Observer {
            if (it == null) {
                Toast.makeText(applicationContext, "Hello FUck", Toast.LENGTH_SHORT).show()
            } else {
                Log.e("Response", it.toString())
            }
        })


    }
}
