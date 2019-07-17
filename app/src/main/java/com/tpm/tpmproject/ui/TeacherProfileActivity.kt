package com.tpm.tpmproject.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tpm.tpmproject.R
import kotlinx.android.synthetic.main.activity_teacher_profile.*

class TeacherProfileActivity : AppCompatActivity() {

    companion object{
        const val TEACHER_NAME = "teacher_name"
        const val TEACHER_IMAGE = "teacher_image"
        fun newIntent(context: Context,teacherName : String , teacherImage: Int): Intent
        {
            var intent = Intent(context,TeacherProfileActivity::class.java)
            intent.putExtra(TEACHER_NAME,teacherName)
            intent.putExtra(TEACHER_IMAGE,teacherImage)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_profile)

        var teacherName = intent.getStringExtra(TEACHER_NAME)
        var teacherImage = intent.getIntExtra(TEACHER_IMAGE,0)
        tvTeacherName.text = teacherName
        ivTeacherProfile.setImageResource(teacherImage)

        btnBackTeacher.setOnClickListener {
            onBackPressed()
            true
        }
    }
}
