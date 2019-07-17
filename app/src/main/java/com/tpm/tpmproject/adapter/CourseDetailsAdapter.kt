package com.tpm.tpmproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tpm.tpmproject.adapter.viewholders.CourseDetailVIewHolder

class CourseDetailsAdapter(var context: Context,var layout : Int,var list : List<String>):
    RecyclerView.Adapter<CourseDetailVIewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseDetailVIewHolder {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(layout,parent,false)
        return  CourseDetailVIewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: CourseDetailVIewHolder, position: Int) {
        holder.courseDetail.text = list[position]
    }
}