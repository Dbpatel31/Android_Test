package com.example.androidtest

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private val PREF_NAME = "shared_preferense"
    private val MOBILE_NUM = "mobile_no"
    private val IS_LOGGIN = "is_login"
    private val BASE_URL= "https://strengthen-numbers-stag.dev-imaginovation.net/"
    private lateinit var mobileEditText : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
         mobileEditText = findViewById(R.id.mobileno)
        var continuebtn = findViewById<Button>(R.id.continuebtn)



        continuebtn.setOnClickListener {

            if (mobileEditText.text.toString().isEmpty()) {
                Toast.makeText(applicationContext, "please Enter Your Number", Toast.LENGTH_SHORT)
                    .show()
            } else {
                postData()
                sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString(MOBILE_NUM, mobileEditText.text.toString())
                editor.putBoolean(IS_LOGGIN, false)
                editor.apply()
                postData()

            }
        }
    }

    private fun postData(){

//        "+19664576602"

        CoroutineScope(Dispatchers.IO).launch {
            val retrofit= Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)
            val retrodata= retrofit.getOtp(mobileEditText.text.toString()).awaitResponse()
            withContext(Dispatchers.Main){
                val bundle= Bundle()
                bundle.putString("conumber",mobileEditText.text.toString())
                val intent= Intent(this@LoginActivity, OtpActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}
