package com.example.androidtest

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private val PREF_NAME= "shared_preferense"
    private val MOBILE_NUM= "mobile_no"
    private val IS_LOGGIN= "is_login"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val splashimage = findViewById<ImageView>(R.id.splash)
        sharedPreferences= getSharedPreferences(PREF_NAME, MODE_PRIVATE)

        if (sharedPreferences.getBoolean(IS_LOGGIN, true)) {
            Handler(Looper.getMainLooper()).postDelayed(
                Runnable {
                    val intent = Intent(this, OtpActivity::class.java)
                    startActivity(intent)
                },
                3000
            )
        }
        else{

                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)



        }
    }
}