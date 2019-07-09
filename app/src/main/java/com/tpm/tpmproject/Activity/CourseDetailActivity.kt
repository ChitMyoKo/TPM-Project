package com.tpm.tpmproject.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.tpm.tpmproject.Adapter.CourseDetailsAdapter
import com.tpm.tpmproject.R
import kotlinx.android.synthetic.main.activity_course_detail.*

class CourseDetailActivity : AppCompatActivity() {
    companion object{
        fun newIntent(context: Context): Intent
        {
            var intent = Intent(context,CourseDetailActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)

        var courseDetailsArr = mutableListOf<String>(
                                "1. Version Control and Git",
                                "2. Kotlin Programming",
                                "3. Installation First App",
                                "4. Activity and Activity Life Cycle",
                                "5. Intent",
                                "6. Fragment and Fragment Life Cycle")
        var adapter = CourseDetailsAdapter(this,R.layout.course_detail,courseDetailsArr)
        rcCourseDetails.layoutManager = LinearLayoutManager(this)
        rcCourseDetails.adapter = adapter
    }
}
