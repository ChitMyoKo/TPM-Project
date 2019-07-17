package com.tpm.tpmproject.adapter.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tpm.tpmproject.model.Student
import kotlinx.android.synthetic.main.student.view.*

class StudentViewHolder(private var view: View,private val onItemClick: (student : Student) -> Unit): RecyclerView.ViewHolder(view) {
    fun setData(student: Student)
    {
        view.tvStudentName.text = student.name
        view.tvStudentProfession.text = student.profession
        view.ivStudents.setImageResource(student.profile)

        view.setOnClickListener {
            onItemClick(student)
        }
    }
}