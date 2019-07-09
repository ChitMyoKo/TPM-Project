package com.tpm.tpmproject.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tpm.tpmproject.R

class StudentProfileActivity : AppCompatActivity() {
    companion object
    {
        fun newIntent(context: Context): Intent
        {
            var intent = Intent(context,StudentProfileActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_profile)
    }
}
