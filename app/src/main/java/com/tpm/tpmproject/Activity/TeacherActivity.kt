package com.tpm.tpmproject.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.tpm.tpmproject.Adapter.PersonAdapter
import com.tpm.tpmproject.DataClass.Person
import com.tpm.tpmproject.R
import kotlinx.android.synthetic.main.activity_teacher.*

class TeacherActivity : AppCompatActivity() {

    companion object{
        fun newIntent(context: Context): Intent
        {
            var intent = Intent(context,TeacherActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)
        var teacher_1 = Person("Taw Zin Aung","Android")
        var teacher_2 = Person("Kyaw Kyaw Khaing","Android")
        var teacher_3 = Person("Phone Lin Aung","Android")
        var teacher_4 = Person("Myo Sat Paing","Android")
        var personArray = mutableListOf<Person>(teacher_1,teacher_2,teacher_3,teacher_4)
        var adapter = PersonAdapter(this,R.layout.person,personArray)
        rcTeacher.layoutManager = GridLayoutManager(this,2)
        rcTeacher.adapter = adapter
    }
}
