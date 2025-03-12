package com.example.androidtest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
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
import retrofit2.create

class OtpActivity : AppCompatActivity() {

    private lateinit var verifyEditText: EditText
    private val BASE_URL= "https://strengthen-numbers-stag.dev-imaginovation.net/"
    private lateinit var responseOtp: ResponseOtp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_otp)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        verifyEditText= findViewById(R.id.verifyEditText)
        val verificationbtn= findViewById<Button>(R.id.verificationbtn)
        verificationbtn.setOnClickListener {
            verifyData()
        }


    }

     private fun verifyData(){
         val bundle= intent.extras
         var number= bundle?.getString("conumber")

        CoroutineScope(Dispatchers.IO).launch {
            val retrofit= Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)
            val retrodata= retrofit.getVerifyOtp(number.toString(),verifyEditText.text.toString().toInt()).awaitResponse()
            val header= retrodata.headers() ?: return@launch
            Log.d("LoginActivity", "$header")
           withContext(Dispatchers.Main){
               val bundle=Bundle()
//               bundle.putString("name", retrodata.body()?.data?.username.toString())
               bundle.putInt("latitude",retrodata.body()?.data?.latitude!!.toInt())
               bundle.putInt("longitude",retrodata.body()?.data?.longitude!!.toInt())
              val intent= Intent(this@OtpActivity,PermissionActivity::class.java)
               intent.putExtras(bundle)
               startActivity(intent)
           }
        }
     }
}