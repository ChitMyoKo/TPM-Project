package com.tpm.tpmproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tpm.tpmproject.R
import com.tpm.tpmproject.adapter.viewholders.ActivitiesViewHolder
import com.tpm.tpmproject.model.Activities

class ActivitiesAdapter(private var list: List<Activities>,private val onClickItem:(activity: Activities)-> Unit): RecyclerView.Adapter<ActivitiesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.activities,parent,false)
        return ActivitiesViewHolder(view,onClickItem)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        holder.setData(list[position])
    }

}