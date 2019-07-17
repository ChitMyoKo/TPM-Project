package com.tpm.tpmproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tpm.tpmproject.model.Student
import com.tpm.tpmproject.R
import com.tpm.tpmproject.adapter.viewholders.StudentViewHolder

class StudentAdapter(var list: List<Student>,private val onItemClick:(student : Student)-> Unit ): RecyclerView.Adapter<StudentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.student,parent,false)
        return StudentViewHolder(view,onItemClick)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.setData(list[position])
    }

}