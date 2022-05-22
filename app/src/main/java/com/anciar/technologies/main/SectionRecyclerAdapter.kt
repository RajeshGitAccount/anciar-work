package com.anciar.technologies.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anciar.technologies.databinding.RecyclerItemHeaderBinding
import com.anciar.technologies.databinding.SectionRecyclerViewBinding
import com.anciar.technologies.main.model.SectionsModel

class SectionRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var sectionInfo:ArrayList<SectionsModel> = ArrayList()
        set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class BodyHolder(itemView: SectionRecyclerViewBinding) : RecyclerView.ViewHolder(itemView.root) {
        val view = itemView
    }

    inner class HeaderHolder(itemView: RecyclerItemHeaderBinding): RecyclerView.ViewHolder(itemView.root) {
        val headerView = itemView
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            0 -> HeaderHolder(RecyclerItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> BodyHolder(SectionRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType){
            0 ->(holder as (HeaderHolder)).headerView.header = sectionInfo[position].sectionName
            else -> (holder as (BodyHolder)).view.model = sectionInfo[position]
        }
    }


    override fun getItemCount(): Int  = sectionInfo.size

    override fun getItemViewType(position: Int): Int {
        return position % 5

    }

    fun getSectionTitle(position: Int) = if (position in sectionInfo.indices) {
        sectionInfo[position].sectionName
    } else {
        ""
    }


}