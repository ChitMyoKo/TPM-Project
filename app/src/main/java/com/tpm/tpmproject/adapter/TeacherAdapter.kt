package com.tpm.tpmproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tpm.tpmproject.R
import com.tpm.tpmproject.model.Teacher
import com.tpm.tpmproject.adapter.viewholders.TeacherViewHolder

class TeacherAdapter(var list: List<Teacher>,private val onClickItem : (teacher : Teacher)->  Unit): RecyclerView.Adapter<TeacherViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.teacher,parent,false)
        return TeacherViewHolder(view,onClickItem)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        holder.setData(list[position])
        }
    }

