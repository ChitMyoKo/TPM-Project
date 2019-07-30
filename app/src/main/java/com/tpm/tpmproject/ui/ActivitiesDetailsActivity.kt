package com.tpm.tpmproject.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tpm.tpmproject.R
import kotlinx.android.synthetic.main.activity_activities_details.*

class ActivitiesDetailsActivity : AppCompatActivity() {

    companion object
    {
        const val TITLE = "activities_title"
        const val BODY = "activities_body"
        const val ACTIVITIES_IMAGE = "activities_bgImage"

        fun newIntent(context : Context,title: String, body : String , bgImage : Int): Intent{
            val intent = Intent(context,ActivitiesDetailsActivity::class.java)
            intent.putExtra(TITLE,title)
            intent.putExtra(BODY,body)
            intent.putExtra(ACTIVITIES_IMAGE,bgImage)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activities_details)
        tvActivitiesTitle.text= intent.getStringExtra(TITLE)
        tvActivitiesDetailBody.text = intent.getStringExtra(BODY)
        ivActivitiesDetailsBg.setImageResource(intent.getIntExtra(ACTIVITIES_IMAGE,0))

        btnBackActivitiesDetails.setOnClickListener {
            onBackPressed()
            true
        }
    }
}
