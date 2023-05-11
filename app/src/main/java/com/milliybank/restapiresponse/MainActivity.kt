package com.milliybank.restapiresponse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gennisteacherapp.network.retrofit.RetrofitHttp
import com.milliybank.restapiresponse.adapter.UserAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView_main_id)
        recyclerView.layoutManager = LinearLayoutManager(this)
        apiList()
    }
    private  fun refreshAdapter(data:ArrayList<UsersListItem>){
        val adapter = UserAdapter(data)
        recyclerView.adapter = adapter
    }

    private fun apiList(){
        val progressBar = findViewById<ProgressBar>(R.id.progressBar_id)
        progressBar.visibility = View.VISIBLE

        RetrofitHttp.retrofitService().usersList().enqueue(object :Callback<UsersList>{

            override fun onResponse(call: Call<UsersList>, response: Response<UsersList>) {
                progressBar.visibility = View.GONE
                Log.d("@@@", response.body().toString())
                if (response.isSuccessful){
                    refreshAdapter(response.body()!!)
                }
            }

            override fun onFailure(call: Call<UsersList>, t: Throwable) {
                Log.d("@@@", t.message.toString())
                progressBar.visibility = View.GONE
            }
        })
    }
}