package com.anciar.technologies.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anciar.technologies.databinding.UserRecyclerAdapterBinding
import com.anciar.technologies.main.model.UserModelItem

class UserRecyclerAdapter : RecyclerView.Adapter<UserRecyclerAdapter.Holder>() {

    var userData: ArrayList<UserModelItem> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class Holder(var userRecyclerAdapterBinding: UserRecyclerAdapterBinding) : RecyclerView.ViewHolder(userRecyclerAdapterBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = UserRecyclerAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.userRecyclerAdapterBinding.model = userData[position]
    }

    override fun getItemCount(): Int = userData.size
}