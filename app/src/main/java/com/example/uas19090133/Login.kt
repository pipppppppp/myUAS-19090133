package com.example.uas19090133

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_login.setOnClickListener {
            val intent = Intent(this@Login, menu::class.java)
            val user = username.text.toString()
            val pass = password.text.toString()
            if ((user == "19090133" && pass == "19090133")){
                startActivity(intent)
            }
        }

//        show and hidden password
        cbshow.setOnClickListener {
            if (cbshow.isChecked) {
                password.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                password.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }
    }
}