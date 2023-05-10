package com.example.gennisteacherapp.network.retrofit

import com.milliybank.restapiresponse.network.RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHttp {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
    }

    fun retrofitService(): RetrofitService {
        return getRetrofit().create(RetrofitService::class.java)
    }
}