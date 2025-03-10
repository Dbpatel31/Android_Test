package com.example.androidtest

import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class LoginActivity : AppCompatActivity() {
    private val requestcode= 100
    private lateinit var sharedPreferences: SharedPreferences
    private val PREF_NAME = "shared_preferense"
    private val MOBILE_NUM = "mobile_no"
    private val IS_LOGGIN = "is_login"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        var mobileEditText = findViewById<EditText>(R.id.mobileno)
        var continuebtn = findViewById<Button>(R.id.continuebtn)



        continuebtn.setOnClickListener {


                if (mobileEditText.text.toString().isEmpty()) {
                    Toast.makeText(
                        applicationContext,
                        "Please Enter Your Number",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else {
                    sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString(MOBILE_NUM, mobileEditText.text.toString())
                    editor.putBoolean(IS_LOGGIN, false)
                    editor.apply()
                    val i = Intent(this@LoginActivity, PermissionActivity::class.java)
                    startActivity(i)
//                    postData()

                }
            }
        }
        }



//    private fun postData() {
//        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).build()
//            .create(ApiService::class.java)
//        val request = PostOtp("+19099968325")
//        val retrodata = retrofit.getOtp(request)
//
//        retrodata.enqueue(object : Callback<List<OtpModel>> {
//            override fun onResponse(
//                call: Call<List<OtpModel>>,
//                response: Response<List<OtpModel>>
//            ) {
//                val data = response.body() ?: return
//
//
//                Log.d("MainActivity","Response Successfully")
//            }
//
//            override fun onFailure(call: Call<List<OtpModel>>, t: Throwable) {
//
//            }
//
//        })
//    }
















