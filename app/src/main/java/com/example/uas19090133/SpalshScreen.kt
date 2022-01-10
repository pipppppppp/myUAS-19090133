package com.example.uas19090133

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SpalshScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh_screen)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(
                Intent(this@SpalshScreen,
                    Login::class.java)
            )
            finish()
        }, 3000)
    }
}