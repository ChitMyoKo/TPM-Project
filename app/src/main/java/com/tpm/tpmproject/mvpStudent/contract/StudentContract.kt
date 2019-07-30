package com.tpm.tpmproject.mvpStudent.contract

import com.tpm.tpmproject.model.Student

interface StudentContract {
    interface StudentView{
        fun showStudentList(studentList:MutableList<Student>)
        fun showFilterStudentList(studentFilterList:MutableList<Student>)
        fun hideBottomSheet()
    }

    interface StudentPresenter{
        fun attachView(view: StudentView)
        fun loadStudentList()
        fun loadFilterStudentList(android: String,php: String,java: String,male: String, female : String)
    }
}