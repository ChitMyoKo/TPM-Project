package com.tpm.tpmproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tpm.tpmproject.Activity.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            startActivity(MainActivity.newIntent(this))
        }
    }
}
