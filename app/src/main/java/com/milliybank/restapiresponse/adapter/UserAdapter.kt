package com.milliybank.restapiresponse.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.milliybank.restapiresponse.R
import com.milliybank.restapiresponse.UsersListItem

class UserAdapter(var list: ArrayList<UsersListItem>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
      return UserViews(view)
    }

    override fun getItemCount(): Int {
      return  list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = list[position]
        if (holder is UserViews){
            holder.textTitle.text = user.title.toUpperCase()
        }
    }

    inner class UserViews(view: View):RecyclerView.ViewHolder(view){
        val textTitle:TextView =view.findViewById(R.id.text_title_id)
    }
}