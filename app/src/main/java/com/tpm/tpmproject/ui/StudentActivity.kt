package com.tpm.tpmproject.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.GridLayoutManager
import com.tpm.tpmproject.adapter.StudentAdapter
import com.tpm.tpmproject.model.Student
import com.tpm.tpmproject.R
import kotlinx.android.synthetic.main.activity_student.*

class StudentActivity : AppCompatActivity() {

    companion object{
        fun newIntent(context: Context): Intent
        {
            var intent = Intent(context,StudentActivity::class.java)
            return  intent
        }
    }
    lateinit var studentArr : List<Student>
    private val studentAdapter  : StudentAdapter by lazy { StudentAdapter(studentArr,this::onItemClick) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        studentToolbar.setTitle(R.string.studentToolbar)
        setSupportActionBar(studentToolbar)

        var student_1 = Student("Ye Lin Aung","Android",R.drawable.yla)
        var student_2 = Student("Mya Mya Khaing","Android",R.drawable.mmk)
        var student_3 = Student("Chit Myo Ko","Android",R.drawable.cmk)
        var student_4 = Student("Pyae Pyae Win","Android",R.drawable.ppw)

        studentArr = mutableListOf<Student>(student_1,student_2,student_3,student_4)
        rcStudent.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = studentAdapter
        }
        rcStudent.layoutManager = GridLayoutManager(this,2)
        rcStudent.adapter = studentAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.filter,menu)
        return true
    }

    private fun onItemClick(student : Student)
    {
        startActivity(StudentProfileActivity.newIntent(this,student.name,student.profession,student.profile))
    }
}
