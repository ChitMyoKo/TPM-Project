package com.tpm.tpmproject.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tpm.tpmproject.DataClass.Course
import com.tpm.tpmproject.ViewHolders.CourseViewHolder

class CourseAdapter(var context: Context,var layout: Int, var list: List<Course>): RecyclerView.Adapter<CourseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
       var inflater = LayoutInflater.from(context)
       var view = inflater.inflate(layout,parent,false)
       return CourseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.courseName.text = list[position].courseName
    }
}