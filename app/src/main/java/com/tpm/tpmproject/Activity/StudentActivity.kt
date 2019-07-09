package com.tpm.tpmproject.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.tpm.tpmproject.Adapter.PersonAdapter
import com.tpm.tpmproject.DataClass.Person
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        var student_1 = Person("Ye Lin Aung","Android",R.drawable.msp)
        var student_2 = Person("Mya Mya Khaing","Android",R.drawable.msp)
        var student_3 = Person("Chit Myo Ko","Android",R.drawable.msp)
        var student_4 = Person("Pyae Pyae Win","Android",R.drawable.msp)

        var studentArr = mutableListOf<Person>(student_1,student_2,student_3,student_4)
        var adapter  = PersonAdapter(this,R.layout.person,studentArr)
        rcStudent.layoutManager = GridLayoutManager(this,2)
        rcStudent.adapter = adapter

    }
}
