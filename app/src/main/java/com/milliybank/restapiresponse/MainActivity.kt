package com.milliybank.restapiresponse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.gennisteacherapp.network.retrofit.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

    }

    private fun initViews() {
        RetrofitHttp.retrofitService().usersList().enqueue(object :Callback<UsersList>{

            override fun onResponse(call: Call<UsersList>, response: Response<UsersList>) {
                Log.d("@@@", response.body().toString())
            }

            override fun onFailure(call: Call<UsersList>, t: Throwable) {

            }
        })
    }
}