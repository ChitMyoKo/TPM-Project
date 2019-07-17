package com.tpm.tpmproject.adapter.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tpm.tpmproject.model.Teacher
import kotlinx.android.synthetic.main.teacher.view.*

class TeacherViewHolder(var view: View,private val onClickItem : (teacher : Teacher)-> Unit): RecyclerView.ViewHolder(view) {

    fun setData(teacher: Teacher)
    {
        view.tvPersonName.text = teacher.name
        view.tvProfession.text = teacher.profession
        view.ivPerson.setImageResource(teacher.profile)

        view.setOnClickListener {
            onClickItem(teacher)
        }
    }
}