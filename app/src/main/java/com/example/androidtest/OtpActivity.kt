package com.example.androidtest

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class OtpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_otp)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }


    }

    private fun postData(){
        val retrofit= Retrofit. Builder().addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)
        val request= PostOtp("+19099968325","1234")
        val retrodata= retrofit.getOtp(request)

        retrodata.enqueue(object : Callback<List<OtpModel>>{
            override fun onResponse(
                call: Call<List<OtpModel>>,
                response: Response<List<OtpModel>>
            ) {
                val data= response.body() ?: return
                Toast.makeText(applicationContext,"Response Successfully done",Toast.LENGTH_SHORT).show()
 
            }

            override fun onFailure(call: Call<List<OtpModel>>, t: Throwable) {
                Toast.makeText(applicationContext,"Response not getting",Toast.LENGTH_SHORT).show()
            }

        })
    }
}