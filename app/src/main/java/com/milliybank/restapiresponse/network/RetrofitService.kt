package com.milliybank.restapiresponse.network

import com.milliybank.restapiresponse.UsersList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitService {

    @Headers("Content-type:application/json")

    @GET("todos")
    fun  usersList():Call<UsersList>

}