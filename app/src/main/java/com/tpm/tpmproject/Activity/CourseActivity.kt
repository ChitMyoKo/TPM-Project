package com.tpm.tpmproject.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.tpm.tpmproject.Adapter.CourseAdapter
import com.tpm.tpmproject.DataClass.Course
import com.tpm.tpmproject.R
import kotlinx.android.synthetic.main.activity_course.*

class CourseActivity : AppCompatActivity() {
    companion object {
        fun newIntent(context: Context): Intent {
            var intent = Intent(context, CourseActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)
        var course_1 = Course("Java")
        var course_2 = Course("PHP")
        var courseArr = mutableListOf<Course>(course_1, course_2)
        var adapter = CourseAdapter(this,R.layout.course,courseArr)
        rcCourse.layoutManager = LinearLayoutManager(this)
        rcCourse.adapter = adapter
    }
}
