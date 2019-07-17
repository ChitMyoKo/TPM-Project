package com.tpm.tpmproject.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tpm.tpmproject.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    companion object
    {
        fun newIntent(context : Context): Intent
        {
            var intent = Intent(context,LoginActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            if(edUserName.text.toString().equals("") && edPassword.text.toString().equals("")) {
                edUserName.error = "User name is required!"
                edPassword.error = "Password is required!"
            }
            else if(edUserName.text.toString().equals("") && !edPassword.text.toString().equals(""))
                edUserName.error = "User name is required!"
            else if(!edUserName.text.toString().equals("") && edPassword.text.toString().equals(""))
                edPassword.error = "Password is required!"
            else
            {
                startActivity(MainActivity.newIntent(this))
                finish()
            }
        }
    }
}
