package com.tpm.tpmproject.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tpm.tpmproject.R
import kotlinx.android.synthetic.main.activity_student_profile.*

class StudentProfileActivity : AppCompatActivity() {
    companion object
    {
        const val NAME = "name"
        const val PROFESSION = "profession"
        const val IMAGE = "image"
        fun newIntent(context: Context,name : String , profession : String,image : Int): Intent
        {
            var intent = Intent(context,StudentProfileActivity::class.java)
            intent.putExtra(NAME,name)
            intent.putExtra(PROFESSION,profession)
            intent.putExtra(IMAGE,image)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_profile)
        var name = intent.getStringExtra(NAME)
        var profession = intent.getStringExtra(PROFESSION)
        var image = intent.getIntExtra(IMAGE,0)
        tvNameProfile.text = name
        tvProfileProfession.text = profession
        ivProfile.setImageResource(image)
        btnBack.setOnClickListener {
            onBackPressed()
            true
        }
    }
}
